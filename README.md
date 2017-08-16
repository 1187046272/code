# JavaMediaToolkits介绍 #

针对Windows平台，基于各种开源第三方多媒体处理库，用Java封装一套统一的多媒体处理类库。
1.制作单机版本处理类库
2.增加分布式特性

## 功能列表 ##
**视频处理类**
- 视频信息获取 大小 时长 。。。
- 流化处理（网页中可拖动进度） hint yamdi
- 视频转码 按格式
- 视频剪切 按时间 按大小
- 视频拼接 多段视频合成一段。。。
- 视频缩略图
- 视频加水印
- 画中画
- 视频生成gif图片
- 视频分离音频通道、附加音频通道
- 图片组生成视频

**图片处理类**
- 获取图片基本信息 大小，格式。。
- base64编解码
- 二维码生成与识别
- 水印
- 裁剪
- 缩放
- 旋转
- 透明化
- 改色
- 切片
- 加文字、图片等水印
- gif生成

**文档处理类**
- 数据生成 pdf,excel生成
- 网页生成pdf
- word,txt生成swf flash

**其他类**
- 系统状态获取:CPU、内存占用、磁盘占用、网络
- 进程管理：查询、开启、杀死（exe和Java程序）
- Java Common Utils
- 串口和并口通信
- ......

## 依赖的类库列表(顺序不分先后) ##
- ffmpeg
- yamdi
- handbreak
- mp4box
- mediainfo
- mencoder
- sigar.jar
- jacob
- rxtx
- wkhtmltopdf
- ImageMagick
- poi.jar
