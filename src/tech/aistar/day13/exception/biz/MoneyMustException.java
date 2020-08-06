package tech.aistar.day13.exception.biz;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/6 21:09
 */
public class MoneyMustException extends Exception{
    public MoneyMustException() {
    }

    public MoneyMustException(String message) {
        super(message);
    }

    public MoneyMustException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoneyMustException(Throwable cause) {
        super(cause);
    }

    public MoneyMustException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
