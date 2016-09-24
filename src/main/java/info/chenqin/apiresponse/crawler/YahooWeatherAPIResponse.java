package info.chenqin.apiresponse.crawler;

import info.chenqin.apiresponse.BaseAPIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 21/09/2016
 * <p/>
 * Time: 12:50 AM
 * <p/>
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class YahooWeatherAPIResponse extends BaseAPIResponse
{
    private List<WeatherForecastDailyInfoModel> weatherForecastDailyInfoModelList;

    public YahooWeatherAPIResponse(int code)
    {
        super(code);
    }

    public YahooWeatherAPIResponse(int code, String message)
    {
        super(code, message);
    }

    public YahooWeatherAPIResponse(int code, List<WeatherForecastDailyInfoModel> weatherForecastDailyInfoModelList)
    {
        super(code);
        this.weatherForecastDailyInfoModelList = weatherForecastDailyInfoModelList;
    }
}
