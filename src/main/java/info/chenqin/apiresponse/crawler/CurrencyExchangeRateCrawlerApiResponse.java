package info.chenqin.apiresponse.crawler;

import info.chenqin.apiresponse.BaseAPIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 12:38 AM
 * <p>
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class CurrencyExchangeRateCrawlerApiResponse extends BaseAPIResponse
{
    private CurrencyExchangeRateInfoModel currencyExchangeRateInfoModel;

    public CurrencyExchangeRateCrawlerApiResponse(int code)
    {
        super(code);
    }

    public CurrencyExchangeRateCrawlerApiResponse(int code, String message)
    {
        super(code, message);
    }

    public CurrencyExchangeRateCrawlerApiResponse(int code, CurrencyExchangeRateInfoModel currencyExchangeRateInfoModel)
    {
        super(code);
        this.currencyExchangeRateInfoModel = currencyExchangeRateInfoModel;
    }
}
