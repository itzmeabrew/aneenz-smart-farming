import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeatherService
{

  LAT: string = "9.369336";
  LNG: string = "76.583231";
  appId: string = "08f55c90780d0db2e7619eb9fb15c957";

  constructor(private http: HttpClient) { }

  public getHistoricWeather(): Observable<any>
  {
    return this.http.get("https://api.openweathermap.org/data/2.5/onecall?lat=" + this.LAT + "&lon=" + this.LNG + "&exclude=current,minutely&appid=" + this.appId + "&unit=metric");
  }

  public getCurrentWeather(): Observable<any>
  {
    return this.http.get("https://api.openweathermap.org/data/2.5/weather?lat=" + this.LAT + "&lon=" + this.LNG + "&appid=" + this.appId);
  }
}
