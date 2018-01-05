**常年保留 `master` 、`release`、`normal`分支**

其中 `master` 和 `release` 已受保护，`normal`为常规分支。

1. **协作开发**

需创建独立分支的请从`master`分支上创建新分支，上线直接合并至`master`分支。

上线任务结束后反向`master`分支到`normal`分支，同时**删除创建的独立分支**。

1. **独立开发/bug**

对于一些个人开发的小需求或bug最好就不用在远程仓库中新建分支了。

自己从`normal`分支上检出一个自己的分支（最好以`dev_{taskId}/[desc]`、`bug_{bugId}/[desc]`的命名方式命名）。

提测时`merge`自己新建的本地分支到`normal`上。

回退或者其他原因上不了线的**自觉**从`normal`上撤销自己的代码。以免带上线！！！


1. **紧急**

一般情况下`release`（紧急分支）分支不常用，如遇紧急上线的最好先反向下`master`分支到`release`分支，然后再从`release`检出自己要修复的`hotfix_xxx`。