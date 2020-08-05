package tech.aistar.day12;

/**
 * 本类功能:枚举类型
 *
 * @author cxylk
 * @date 2020/8/5 19:22
 */
public enum  EnumDemo3 {

    SPRING("春天") {
        @Override
        public EnumDemo3 next() {
            return SUMMER;
        }
    },

    SUMMER("夏天"){
        @Override
        public EnumDemo3 next(){
            return WINTER;
        }
    },

    WINTER("冬天"){
        @Override
        public EnumDemo3 next(){
            return SPRING;
        }
    };

    private EnumDemo3(String sign){
        this.sign=sign;
    }

    //定义普通的属性
    private String sign;

    public String getSign(){
        return sign;
    }

    //可以提供一个抽象方法 - 每个枚举实例都是要去重写这个抽象方法的
    public abstract EnumDemo3 next();
}
