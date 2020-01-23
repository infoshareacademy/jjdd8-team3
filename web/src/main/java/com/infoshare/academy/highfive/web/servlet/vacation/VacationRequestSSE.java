package com.infoshare.academy.highfive.web.servlet.vacation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.academy.highfive.domain.VacationStatus;
import com.infoshare.academy.highfive.dto.view.VacationView;
import com.infoshare.academy.highfive.service.VacationService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/notify")
public class VacationRequestSSE extends HttpServlet {

    @Inject
    private VacationService vacationService;

/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");

        //resp.getWriter().write("retry: 20000\n");

        List<VacationView> vacationViews = vacationService.listAllPendingRequests()
                .stream()
                .filter(v -> v.getVacationStatus().equals(VacationStatus.APPLIED))
                .sorted((o1, o2) -> o2.getDateOfRequest().compareTo(o1.getDateOfRequest()))
                .limit(4)
                .collect(Collectors.toList());

        String listToJson = mapper.writeValueAsString(vacationViews);

      resp.getWriter().write(listToJson);

    }*/

}