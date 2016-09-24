package info.chenqin.common;

/**
 * User: nathanchen
 * <p/>
 * Date: 14/09/2016
 * <p/>
 * Time: 10:39 PM
 * <p/>
 * Description:
 */
public enum DBEntryStateEnum
{
    ACTIVE(1), INACTIVE(0);

    private int code;

    DBEntryStateEnum(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
}
