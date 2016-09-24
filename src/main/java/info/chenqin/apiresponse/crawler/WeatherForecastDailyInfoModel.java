package info.chenqin.apiresponse.crawler;

import lombok.Data;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 1:07 AM
 * <p>
 * Description:
 */
@Data
public class WeatherForecastDailyInfoModel
{
    private String date;
    private String lowTemp;
    private String highTemp;
    private String weather;
}
