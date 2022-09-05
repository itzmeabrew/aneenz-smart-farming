import { Component, OnInit, ViewChild } from '@angular/core';
import { ChartConfiguration, ChartEvent, ChartType } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { WeatherService } from 'src/app/services/weather.service';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css'],
})
export class ChartComponent implements OnInit
{
  @ViewChild(BaseChartDirective) chart?: BaseChartDirective;
  public lineChartType: ChartType = 'line';

  tempratureList = new Array();
  timeList = new Array();

  constructor(private wxr: WeatherService){}

  ngOnInit(): void
  {
    this.getHistoricWeather();
  }

  public getHistoricWeather(): void
  {
    this.wxr.getHistoricWeather().subscribe({
      next:(response)=>
      {
        const result = response;
        const hrs_array = result.hourly;

        //console.log(result);

        for(const hr of hrs_array)
        {
          //console.log(hr);
          const hrx = new Date(hr.dt * 1000).toLocaleTimeString()
          this.tempratureList.push(this.KtoC(hr.temp));

          //console.log(hrx);

          this.timeList.push(hrx);
          this.chart?.update();
        }
        //console.log(this.tempratureList);
        //console.log(this.timeList)
      },
      error:(err)=>
      {
        console.error(err);
      }}
    )
  }

  public KtoC(kel:number):number
  {
    return parseInt((kel - 273.15).toFixed(2));
  }

  public lineChartData: ChartConfiguration['data'] =
  {
    datasets:
    [
      {
        data:this.tempratureList,
        //data: [65, 59, 80, 81, 56, 55, 40, 19, 65, 37, 70, 95, 30, 45, 32, 19, 45, 21, 70, 95, 30, 45, 32, 17, 70, 65, 59, 80, 81, 56, 85, 40, 19, 65, 1 ,20, 95, 30, 45, 32, 19, 65, 37, 70, 95, 30, 45, 32, 37, 70],
        label: 'Out Side Air Temprature',
        backgroundColor: 'rgba(255, 0, 0, 0.61)',
        borderColor: 'rgba(255, 0, 0, 0.93)',
        pointBackgroundColor: 'rgba(255, 0, 0, 0.93)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(148,159,177,0.8)',
        fill: 'origin',
      },
    ],
    labels:this.timeList
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
        min:20,
        max:40
      }

    },
    responsive: true,
  };
}
