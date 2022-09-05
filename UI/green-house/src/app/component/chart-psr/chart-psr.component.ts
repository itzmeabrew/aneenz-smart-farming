import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartConfiguration, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { WeatherService } from 'src/app/services/weather.service';

@Component({
  selector: 'app-chart-psr',
  templateUrl: './chart-psr.component.html',
  styleUrls: ['./chart-psr.component.css']
})
export class ChartPsrComponent implements OnInit
{
  @ViewChild(BaseChartDirective) chart?: BaseChartDirective;
  public lineChartType: ChartType = 'line';

  psrList = new Array();
  timeList = new Array();

  constructor(private wxr: WeatherService){}

  ngOnInit(): void
  {
    this.getHistoricWeather();
  }

  public getHistoricWeather(): void
  {
    this.wxr.getHistoricWeather().subscribe({
      next:(rex)=>
      {
        const result = rex;
        const hrs_array = result.hourly;

        //console.log(result);

        for(const hr of hrs_array)
        {
          console.log(hr);
          const hrx = new Date(hr.dt * 1000).toLocaleTimeString()
          this.psrList.push(hr.pressure);

          //console.log(hrx);

          this.timeList.push(hrx);
          this.chart?.update();
        }
      },
      error:(err)=>
      {
        console.error(err);
      }}
    )
  }

  public lineChartData: ChartConfiguration['data'] =
  {
    datasets: [
      {
        data: this.psrList,
        //data: [41,55,35,79,59,34,43,62,26,44,39,63,45,21,25,42,52,33,69,71,47,42,20,42,41,55,35,79,59,34,43,62,26,44,39,63,45,21,25,42,52,33,69,71,47,42,20,42,20],
        label: 'Athmospheric Pressure',
        backgroundColor: 'rgba(44, 97, 255, 0.8)',
        borderColor: 'rgba(0, 56, 224, 0.8)',
        pointBackgroundColor: 'rgba(38, 81, 208, 0.8)',
        pointBorderColor: 'rgba(255, 255, 255, 0)',
        pointHoverBackgroundColor: 'rgba(0, 137, 20, 0.8)',
        pointHoverBorderColor: 'rgba(148,159,177,0.8)',
        fill: 'origin',
      },
    ],
    labels: this.timeList
    /* [
      '00:00','00:30','01:00','01:30','02:00','02:30','03:00','03:30','04:00','04:30','05:00','05:30','06:00','06:30','07:00','07:30','08:00','08:30','09:00','09:30','10:00','10:30','11:00','11:30','12:00','12:30',
      '13:00','13:30','14:00','14:30','15:00','15:30','16:00','16:30','17:00','17:30','18:00','18:30','19:00','19:30','20:00','20:30','21:00','21:30','22:00','22:30','23:00','23:30','24:00',
    ], */
  };

  public lineChartOptions: ChartConfiguration['options'] =
  {
    elements:
    {
      line: {tension: 0.4,}
    },
    scales:
    {
      // We use this empty structure as a placeholder for dynamic theming.
      x: {},
      y:
      {
        min:800,
        max:1200
      }

    },
    responsive: true,
  };


}
