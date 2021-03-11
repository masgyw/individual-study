package cn.gyw.glearn.designpattern.creational.simplefactory;

class OperationAdd extends AbstractOperation {

    public OperationAdd(int arg1, int arg2) {
        super(arg1, arg2);
    }

    @Override
    public int doGetResult() {
        return arg1 + arg2;
    }
}
