# Software-Engineering-Lab-EX8


## گام سوم:
1. علت قابل قبول بودن استفاده از الگوی Strategy
استفاده از الگوی Strategy در این پروژه قابل قبول است زیرا این الگو به ما اجازه می‌دهد تا الگوریتم‌های مختلف پیمایش گراف (مانند BFS و DFS) را به صورت جداگانه و مستقل از یکدیگر پیاده‌سازی کنیم. این مزیت‌ها شامل موارد زیر است:

جداسازی منطق الگوریتم‌ها: هر الگوریتم پیمایش (BFS و DFS) در کلاس‌های جداگانه پیاده‌سازی شده و تغییر یا گسترش هر یک از این الگوریتم‌ها بدون تأثیر بر دیگر بخش‌های کد ممکن است.
انعطاف‌پذیری بالا: می‌توان الگوریتم‌های جدید را به سادگی اضافه کرد یا الگوریتم‌های موجود را تغییر داد، بدون نیاز به تغییر کدهای موجود.
قابلیت جایگزینی: در اینجا می‌توان به راحتی بین الگوریتم‌های مختلف پیمایش گراف با تغییر کلاس Traverser استفاده‌شده در Main جابجا شد.
کاهش پیچیدگی: با جداسازی منطق پیمایش، کلاس اصلی Main ساده‌تر و خواناتر شده است.



۲. روش تحقق الگوی Strategy در این پروژه
الگوی Strategy در این پروژه به صورت زیر پیاده‌سازی شده است:

تعریف اینترفیس (Interface):

یک اینترفیس به نام Traverser تعریف شده که متدی با امضای traverse(Integer startVertex) را مشخص می‌کند. این اینترفیس نقش استراتژی اصلی را دارد و الگوریتم‌های مختلف باید آن را پیاده‌سازی کنند.

public interface Traverser {
    List<Integer> traverse(Integer startVertex);
}



پیاده‌سازی استراتژی‌های مختلف:

دو کلاس BfsGraphTraverser و DfsGraphTraverser از اینترفیس Traverser استفاده کرده و الگوریتم‌های BFS و DFS را به صورت مستقل پیاده‌سازی کرده‌اند.

کلاس BfsGraphTraverser الگوریتم جستجوی سطحی (BFS) را با استفاده از صف (Queue) پیاده‌سازی کرده است.

کلاس DfsGraphTraverser الگوریتم جستجوی عمقی (DFS) را با استفاده از پشته (Stack) پیاده‌سازی کرده است.

استفاده از الگوی Strategy در Main:

در کلاس Main، گراف ساخته شده و سپس یک نمونه از هر دو کلاس BfsGraphTraverser و DfsGraphTraverser ایجاد شده است.
کد به گونه‌ای طراحی شده که می‌توان با تغییر نوع استراتژی (کلاس Traverser) الگوریتم پیمایش گراف را تغییر داد:


Traverser dfsGraphTraveler = new DfsGraphTraverser(graph);
Traverser bfsGraphTraveler = new BfsGraphTraverser(graph);

List<Integer> dfsPath = dfsGraphTraveler.traverse(1);
List<Integer> bfsTraveler = bfsGraphTraveler.traverse(1);


