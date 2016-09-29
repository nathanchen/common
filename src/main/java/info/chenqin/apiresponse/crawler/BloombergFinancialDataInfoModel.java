package info.chenqin.apiresponse.crawler;

import lombok.Data;

/**
 * User: nathanchen
 * <p>
 * Date: 23/9/16
 * <p>
 * Time: 12:46 AM
 * <p>
 * Description:
 */
@Data
public class BloombergFinancialDataInfoModel
{
    private String name;

    // 目前价位
    private String currentValue;

    // 价位波动情况 正数代表涨 负数代表跌
    private String changeValue;
}
