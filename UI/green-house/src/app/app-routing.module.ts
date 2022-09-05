import { IndexComponent } from './component/index/index.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { ChartComponent } from './component/chart/chart.component';
import { CardSelectComponent } from './component/card-select/card-select.component';
import { LandingComponent } from './component/landing/landing.component';
import { ControlPanelComponent } from './component/control-panel/control-panel.component';
import { ChartHumidityComponent } from './component/chart-humidity/chart-humidity.component';
import { ChartPsrComponent } from './component/chart-psr/chart-psr.component';
import { EventCalendarComponent } from './component/event-calendar/event-calendar.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: IndexComponent,
  children: [
    {
      path:  'chart',
      component:  CardSelectComponent
    },
    {
      path:  'temp-chart',
      component:  ChartComponent
    },
    {
      path:  'chart-psr',
      component:  ChartPsrComponent
    },
    {
      path:  'humidity-chart',
      component:  ChartHumidityComponent
    },
    {
      path:  'index',
      component:  LandingComponent
    },
    {
      path:  'control-panel',
      component:  ControlPanelComponent
    },
    {
      path:  'event-calander',
      component:  EventCalendarComponent
    }
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
