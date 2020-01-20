<script src="/js/bootstrap-year-calendar_v2.js"></script>
<script>
    $(function() {
        var currentYear = new Date().getFullYear();

        $('#calendar').calendar({
            enableContextMenu: true,
            enableRangeSelection: false,
            weekStart:1,
            mouseOnDay: function(e) {
                if(e.events.length > 0) {
                    var content = '';

                    for(var i in e.events) {
                        content += '<div class="event-tooltip-content">'
                            + '<div class="event-name" style="color:' + e.events[i].color + '">' + e.events[i].name + '</div>'
                            + '<div class="event-location">' + e.events[i].location + '</div>'
                            + '<div class="event-location">' + e.events[i].type + '</div>'
                            + '</div>';
                    }

                    $(e.element).popover({
                        trigger: 'manual',
                        container: 'body',
                        html:true,
                        content: content
                    });

                    $(e.element).popover('show');
                }
            },
            mouseOutDay: function(e) {
                if(e.events.length > 0) {
                    $(e.element).popover('hide');
                }
            },
            dayContextMenu: function(e) {
                $(e.element).popover('hide');
            },
            dataSource: [
                <#list holidays as holiday>
                {
                    id: ${holiday.id!},
                    name: '${holiday.name!}',
                    location: '${holiday.description!}',
                    type:'${holiday.holidayType.getType()!}',
                    <#if holiday.holidayType.getType() == 'National holiday'>color:'red'<#else>color:'orange'</#if>,
                    startDate: new Date(${holiday.date?substring(0, 4)},${holiday.month-1},${holiday.day}),
                    endDate: new Date(${holiday.date?substring(0, 4)},${holiday.month-1},${holiday.day})
                   }
             <#sep>, </#sep>
        </#list>
            ]
        });

    });
</script>