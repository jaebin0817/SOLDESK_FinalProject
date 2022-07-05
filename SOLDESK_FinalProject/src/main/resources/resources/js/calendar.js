document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prevYear,prev,next,nextYear today',
        center: 'title',
        right: 'dayGridMonth,dayGridWeek,dayGridDay'
      },
      initialDate: '2022-01-11',
      navLinks: true, // can click day/week names to navigate views
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: function(info, successCallback, failureCallback){
		$.ajax({
			type: 'POST',
			url : "/m_manage/calendar.do",
			dataType: 'JSON',
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function(data){
				alert("성공");
		        var events = [];
		        console.log(data);
		        if(data.pValue != null && data.pValue == 'private'){
		          events.push({
		          title: data.title,
		          start : data.start,
		          end : data.end,
		          color: 'red'  
		        });
		      } else if(data.pValue != null && data.pValue == 'public'){
		        events.push({
		        title: data.title,
		        start : data.start,
		        end : data.end,
		        color: 'blue'  
		        });
		      }else {
		        events.push({
		        title: data.title,
		        start : data.start,
		        end : data.end,
		        color: 'green'  
		        });
		      }
		successCallback(events);
      }
    }); 
    }
  });
});
