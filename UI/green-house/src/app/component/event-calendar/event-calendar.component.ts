import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import dayGridPlugin from '@fullcalendar/daygrid';
//const arrowLine = require('arrow-line');

@Component({
  selector: 'app-event-calendar',
  templateUrl: './event-calendar.component.html',
  styleUrls: ['./event-calendar.component.css']
})
export class EventCalendarComponent implements OnInit
{

  eventArray =
  [
    {id:"123",title: 'event 1', date: '2022-05-01',backgroundColor:"red"},
    {id:"234", title: 'event 2', date: '2022-05-10'}
  ];

  calendarOptions: CalendarOptions =
  {
    initialView: 'dayGridMonth',
    dateClick: this.handleDateClick.bind(this), // bind is important!
    editable:true, //
    eventClick: this.handleEventClick.bind(this),
    eventDragStop:this.handleEventDrop.bind(this),
    events: this.eventArray
  };

  constructor() { }

  ngOnInit(): void
  {

  }

  private handleDateClick(arg): void
  {
    alert('date click! ' + arg.dateStr)
  }

  private handleEventClick(eventx): void
  {
    const id = eventx.event.id;
    let event_data = this.eventArray.find(a => a.id === id);

    this.eventArray=this.eventArray.filter((item) => item.id !== id);
    event_data.backgroundColor = "green";
    this.eventArray.push(event_data);

    //this.eventArray=newx;
    //console.log(this.eventArray);
    this.calendarOptions.events = this.eventArray;

    //eventx.el.setAttribute('id',eventx.event.id);
  }

  private handleEventDrop(eventx): void
  {
    console.log("dragged")
    console.log(eventx.jsEvent.clientX,eventx.jsEvent.clientY)
    console.log(eventx.jsEvent.clientX,eventx.jsEvent.clientY)
    //eventx.el.setAttribute('id',eventx.event.id);
  }
}
