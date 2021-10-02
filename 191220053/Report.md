### 代码理解

1. ##### classLoader

    首先是`SteganographyClassLoader`类, 此类继承自`ClassLoader`类, 并在其中覆盖了`findClass()`方法。当通过委派机制在AppClassLoader、PlatformClassLoader和BootStrapClassLoader都没有找到目标时, 最后会返回给这个自定义的加载器, 并且调用`findClass()`方法。在这个方法中, 首先通过`SteganographyEncoder`类的`decodeByteArray()`方法读取并解码隐写图中储藏的.class文件信息(感觉是为了这里实现方便就单独设计了一个decodeByteArray()方法而不直接使用decodeFile()方法来解码), 最后再使用`defineClass()`方法将获得的字节串转换生成一个Class对象并返回。

    

2. ##### encoder

    - `SteganographyFactory`

        这个类主要是先将目标.java文件编译成一个.class文件, 然后通过实例化一个`SteganographyEncoder`对象, 调用其`encodeFile()`方法, 将.class文件中的字节流信息写入并生成目标图像。

    - `SteganographyEncoder`

        代码比较多, 主要是具体的加密方法。拿example中的代码举例, 这里主要是默认的把R、G、B每个的后两bit作为信息储藏位, 将.class的字节信息储存在其中, 包括其名字长度、内容长度、名字内容、字节串内容。





### 隐写术图

- 快排隐写术处理后图片

    ![](https://raw.githubusercontent.com/jwork-2021/jw03-EnxIII/main/191220053/SteganographyPics/example.QuickSorter.png)

     

    

- 选择排序隐写术处理后图片

    ![](https://raw.githubusercontent.com/jwork-2021/jw03-EnxIII/main/191220053/SteganographyPics/example.SelectSorter.png)

     

- 借用的另一个同学的图片 : [作者链接](https://github.com/jwork-2021/jw03-star20001)

    ![](https://raw.githubusercontent.com/jwork-2021/jw03-star20001/main/202220008/url/example.ShellSorter.png)





### 排序视频

- ##### **快排**

    [![asciicast](https://asciinema.org/a/k8QWjO6FROmAsXa47dOgXAuSw.svg)](https://asciinema.org/a/k8QWjO6FROmAsXa47dOgXAuSw)

    

- ##### **选择排序**

    [![asciicast](https://asciinema.org/a/pEVEsmtPJSMYYluMKnvwPY1ug.svg)](https://asciinema.org/a/pEVEsmtPJSMYYluMKnvwPY1ug)

    

- ##### **ShellSort**

    另一位同学的作品: [作者链接](https://github.com/jwork-2021/jw03-star20001)

    [![asciicast](https://asciinema.org/a/qygWlwCS1gImNGh7BDx5QOePZ.svg)](https://asciinema.org/a/qygWlwCS1gImNGh7BDx5QOePZ)



