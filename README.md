## app
使用 retrofit 示例


## databinding

演示使用 android 推出的 DataBinding 进行数据更新

需要在 build.gradle 设置
```java
    dataBinding{
        enabled true
    }
```

注意 POJO 需要 extends BaseObservable 以刷新数据

为 getter 设置 `@Bindable` 或 使用 `ObservableField<T>`

xml 需要配置 ` <import type="android.view.View"/>`
