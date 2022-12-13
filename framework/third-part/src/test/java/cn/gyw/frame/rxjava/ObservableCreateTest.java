package cn.gyw.frame.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author
 * @desc Observable 创建被观察者，发送数据
 * @createdTime 2022/8/25
 */
public class ObservableCreateTest {

    // interval//timer
    // range
    // repeat

    /**
     * 数据结构转换
     */
    @Test
    public void from() {
        Observable.fromArray("a", "b", "c");
        Observable.fromCallable(() -> {
            return 1;});
        // Observable.fromFuture();
        Observable.fromIterable(new ArrayList<>());
        // 将给定对象转成Observable
        Observable.just(123);
    }

    /**
     * 创建空的或不发送数据的Observable
     */
    @Test
    public void empty() {
        Observable.empty();

        Observable.never();
    }

    /**
     * 推迟Observable创建，直到有Observer订阅时，才创建新的 Observable
     */
    @Test
    public void defer() {
        Observable<Integer> a = Observable.defer(()-> Observable.just(123));
        
        Disposable disposable = a.subscribe(System.out::println);
        System.out.println("disposable = " + disposable);
    }
    
    /**
     * 在observer订阅关系违背释放时，
     * 可按程序顺序调用onNext()->onComplete()->onError()
     */
    @Test
    public void create() {
        Disposable disposable = Observable.create(observer -> {
            try {
                if (!observer.isDisposed()) {
                    for (int i = 0; i < 5; i++) {
                        observer.onNext(i);
                    }
                    observer.onComplete();
                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }).subscribe(System.out::println, System.err::println, () -> System.out.println("Sequence complete."));

        System.out.println("disposable = " + disposable);
    }
}
