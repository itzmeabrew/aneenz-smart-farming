import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { IndexComponent } from './component/index/index.component';
import { SidebarComponent } from './component/sidebar/sidebar.component';
import { NavHeaderComponent } from './component/nav-header/nav-header.component';
import { NbCardModule, NbThemeModule, NbTimepickerModule } from '@nebular/theme';
import { FooterComponent } from './component/footer/footer.component';
import { ChartComponent } from './component/chart/chart.component';
import { NgChartsModule } from 'ng2-charts';
import { CardSelectComponent } from './component/card-select/card-select.component';
import { LandingComponent } from './component/landing/landing.component';
import { UiSwitchModule } from 'ngx-ui-switch';
import { ControlPanelComponent } from './component/control-panel/control-panel.component';
import { FacebookLoginProvider, GoogleLoginProvider, SocialAuthServiceConfig, SocialLoginModule } from 'angularx-social-login';
import { ChartHumidityComponent } from './component/chart-humidity/chart-humidity.component';
import { AuthInterceptor } from './auth/auth.interceptor';
import { GaugeModule } from 'angular-gauge';
import { ChartPsrComponent } from './component/chart-psr/chart-psr.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { EventCalendarComponent } from './component/event-calendar/event-calendar.component';

import dayGridPlugin from '@fullcalendar/daygrid'; // a plugin!
import interactionPlugin from '@fullcalendar/interaction';



FullCalendarModule.registerPlugins([ // register FullCalendar plugins
  dayGridPlugin,
  interactionPlugin
]);

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IndexComponent,
    SidebarComponent,
    NavHeaderComponent,
    FooterComponent,
    ChartComponent,
    CardSelectComponent,
    LandingComponent,
    ControlPanelComponent,
    ChartHumidityComponent,
    ChartPsrComponent,
    EventCalendarComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NbThemeModule.forRoot(),
    NbTimepickerModule.forRoot(),
    GaugeModule.forRoot(),
    AppRoutingModule,
    NbCardModule,
    FullCalendarModule,
    NgChartsModule,
    SocialLoginModule,
    ReactiveFormsModule,
    HttpClientModule,
    UiSwitchModule
  ],
  providers: [
    AuthInterceptor,
    {
      provide: 'SocialAuthServiceConfig',
      useValue:
      {
        autoLogin: true,
        providers:
        [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider('403666516473-43qkvaj1ckmmr9f4b6v2j4j62fltlvok.apps.googleusercontent.com')
          },
        ],
        onError: (err) =>
        {
          console.error(err);
        }
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
