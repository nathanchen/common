package info.chenqin.apiresponse.crawler;

import info.chenqin.apiresponse.BaseAPIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User: nathanchen
 * <p/>
 * Date: 18/09/2016
 * <p/>
 * Time: 12:41 PM
 * <p/>
 * Description:
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class OSChinaIndexPageCrawlerApiResponse extends BaseAPIResponse
{
    private List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModels;

    public OSChinaIndexPageCrawlerApiResponse(int code)
    {
        super(code);
    }

    public OSChinaIndexPageCrawlerApiResponse(int code, String message)
    {
        super(code, message);
    }

    public OSChinaIndexPageCrawlerApiResponse(int code, List<OSChinaIndexPageNewsModel> osChinaIndexPageNewsModels)
    {
        super(code);
        this.osChinaIndexPageNewsModels = osChinaIndexPageNewsModels;
    }
}
