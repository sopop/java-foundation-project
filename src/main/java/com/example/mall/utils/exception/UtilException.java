package com.example.mall.utils.exception;

/**
 * 工具类异常
 * 
 * @author ruoyi
 */
public class UtilException extends RuntimeException
{
    private static final long serialVersionUID = 6555778423467766653L;

    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
