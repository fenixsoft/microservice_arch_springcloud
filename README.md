# Fenix's BookStore后端：以SpringCloud微服务实现

<p align="center">
  <a href="https://icyfenix.cn" target="_blank">
    <img width="180" src="https://icyfenix.cn/images/logo-color.png" alt="logo">
  </a>
</p>
<p align="center">
    <a href="https://icyfenix.cn"  style="display:inline-block"><img src="https://icyfenix.cn/images/Release-v1.svg"></a>
    <a href="https://travis-ci.com/fenixsoft/monolithic_arch_springboot" target="_blank"  style="display:inline-block"><img src="https://travis-ci.com/fenixsoft/monolithic_arch_springboot.svg?branch=master" alt="Travis-CI"></a>
    <a href='https://coveralls.io/github/fenixsoft/monolithic_arch_springboot?branch=master'><img src='https://coveralls.io/repos/github/fenixsoft/monolithic_arch_springboot/badge.svg?branch=master'  target="_blank"  style="display:inline-block" alt='Coverage Status' /></a>
    <a href="https://www.apache.org/licenses/LICENSE-2.0"  target="_blank" style="display:inline-block"><img src="https://icyfenix.cn/images/License-Apache.svg" alt="License"></a>
<a href="https://creativecommons.org/licenses/by/4.0/"  target="_blank" style="display:inline-block"><img src="https://icyfenix.cn/images/DocLicense-CC-red.svg" alt="Document License"></a>
    <a href="https://icyfenix.cn/introduction/about-me.html" target="_blank" style="display:inline-block"><img src="https://icyfenix.cn/images/Author-IcyFenix-blue.svg" alt="About Author"></a>
</p>


如果你此时并不曾了解过什么是“The Fenix Project”，建议先阅读<a href="https://icyfenix.cn/introduction/about-the-fenix-project.html">这部分内容</a>。

至少到目前，基于Spring Cloud的微服务解决方案仍是以Java为运行平台的微服务中，使用者数量最多的一个分支。这得益于此前Java在服务端应用的广泛基础，也是得益于Spring在Java应用中统治性的地位。Spring Cloud使现存数量即为庞大的基于Spring和SpringBoot的单体系统，得以平滑地迁移到微服务架构中，其中大部分代码都能够无需或少量修改即可保留重用。它又集成了[Netflix OSS](https://netflix.github.io/)（Netflix闭源后也有着对应的替代组件）所开发的体系化的微服务套，尽可能透明地解决在微服务环境中必然会面临的服务发现、远程调用、负载均衡、集中配置等技术问题。

笔者其实并不太认同Spring Cloud Netflix这种以应用代码去解决基础设施功能问题的“解题思路”，笔者看来这既是容器化、原生化的微服务基础设施完全成熟之前必然会出现的应用形态，同时也决定了这是微服务进化过程中必然会被替代的过渡形态。不过，基于Spring Cloud Netflix的微服务在现在，或者说未来不短的一段时间内仍主流，而且以应用服务的视角，自顶向下观察基础设施在微服务中面临的需求和问题，便于利用我们熟悉的Java代码来解释分析，有利于对微服务的整体思想有更深入的理解，所以将它作为我们了解的第一种微服务架构风格是适合的。

## 运行程序

以下几种途径，可以运行程序，浏览最终的效果：




## 协议

- 本文档代码部分采用[Apache 2.0协议](https://www.apache.org/licenses/LICENSE-2.0)进行许可。遵循许可的前提下，你可以自由地对代码进行修改，再发布，可以将代码用作商业用途。但要求你：
  - **署名**：在原有代码和衍生代码中，保留原作者署名及代码来源信息。
  - **保留许可证**：在原有代码和衍生代码中，保留Apache 2.0协议文件。
  
- 本作品文档部分采用[知识共享署名 4.0 国际许可协议](http://creativecommons.org/licenses/by/4.0/)进行许可。 遵循许可的前提下，你可以自由地共享，包括在任何媒介上以任何形式复制、发行本作品，亦可以自由地演绎、修改、转换或以本作品为基础进行二次创作。但要求你：
  - **署名**：应在使用本文档的全部或部分内容时候，注明原作者及来源信息。
  - **非商业性使用**：不得用于商业出版或其他任何带有商业性质的行为。如需商业使用，请联系作者。
  - **相同方式共享的条件**：在本文档基础上演绎、修改的作品，应当继续以知识共享署名 4.0国际许可协议进行许可。