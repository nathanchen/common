package info.chenqin.apiresponse.crawler;

import info.chenqin.apiresponse.BaseAPIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class BloombergFinancialDataInfoApiResponse extends BaseAPIResponse
{
    private List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList;

    public BloombergFinancialDataInfoApiResponse(int code)
    {
        super(code);
    }

    public BloombergFinancialDataInfoApiResponse(int code, String message)
    {
        super(code, message);
    }

    public BloombergFinancialDataInfoApiResponse(int code, List<BloombergFinancialDataInfoModel> bloombergFinancialDataInfoModelList)
    {
        super(code);
        this.bloombergFinancialDataInfoModelList = bloombergFinancialDataInfoModelList;
    }
}
