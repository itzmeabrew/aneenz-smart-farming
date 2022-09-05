import { AfterContentInit, AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval } from 'rxjs';
import { WeatherService } from 'src/app/services/weather.service';

@Component({
  selector: 'app-card-select',
  templateUrl: './card-select.component.html',
  styleUrls: ['./card-select.component.css']
})
export class CardSelectComponent implements OnInit,AfterContentInit
{
  athmosphricData: any = null;

  constructor(private router: Router,private wxr: WeatherService) { }

  ngOnInit(): void
  {
    this.getWeatherInit();
  }

    // TODO document why this method 'ngOnInit' is empty

  ngAfterContentInit(): void
  {
    interval(2000).subscribe(x =>
      {
        console.log("update interval",x);

        this.getWeatherInit();
      });
  }

  public getWeatherInit():void
  {
    console.log("Get Weather Data");

    this.wxr.getCurrentWeather().subscribe(
      response=>
      {
        const resx = response;
        //console.log(resx);
        const mainx = resx.main;
        this.athmosphricData = mainx;

        console.log(this.athmosphricData);
      },
      error=>
      {
        console.error(error);
      });
  }

  public KtoC(kel:number):string
  {
    return (kel - 273.15).toFixed(2);
  }

  public switchToChart(param:number):void
  {
    console.log("click");
    switch(param)
    {
      case 1:
        this.router.navigateByUrl("temp-chart");
        break;
      case 2:
        this.router.navigateByUrl("humidity-chart");
        break;
      case 3:
        this.router.navigateByUrl("chart-psr");
         break;


      default:
        console.error("wot?");
    }
  }
}
