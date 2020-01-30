package com.infoshare.academy.highfive.web.servlet.vacation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.dto.view.VacationSSE;
import com.infoshare.academy.highfive.service.VacationService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/notify")
public class VacationRequestSSE extends HttpServlet {

    @Inject
    private VacationService vacationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writer().withDefaultPrettyPrinter();
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");

        List<VacationSSE> vacationSSE = vacationService.listAllPendingRequestsSSE()
                .stream()
                .filter(v -> v.getVacationStatus().equals(VacationStatus.APPLIED))
                .sorted((a, b) -> (int) (Timestamp.valueOf(b.getDateOfRequest()).getTime() - Timestamp.valueOf(a.getDateOfRequest()).getTime()))
                //.sorted(Comparator.comparing(VacationSSE::getDateOfRequest))
//                //.sorted(Collections.reverse())
              .limit(1)
             .collect(Collectors.toList());
        //.collect(Collectors.toCollection(TreeSet::new));

//        Collections.sort(vacationSSE,
//                (a, b) -> (int) (Timestamp.valueOf(b.getDateOfRequest()).getTime() - Timestamp.valueOf(a.getDateOfRequest()).getTime()));

        String listToJson = mapper.writeValueAsString(vacationSSE);

        resp.getWriter().write("retry: 10000\n");
        resp.getWriter().write("data:" + listToJson + "\n\n");

    }

}