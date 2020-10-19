/**
 * date： 2020/07/26
 * author：江理网猿
 */

// SummerNote发生文件（图片）到服务器上的默认方法
function defaultSendFile(uploadUrl, file){
    let timestamp = new Date().getTime();
    let data = new FormData();
    data.append("file", file);
    data.append("timestamp", String(timestamp));

    return new Promise(resolve => {
        resolve(WebDao.postFile(uploadUrl, data));
    });
}

function initSummerNote(summerNoteId, uploadUrl, sendFunc=defaultSendFile) {
    // 初始化绑定渲染
    $(summerNoteId).summernote({
        lang:"zh-CN",
        // disableDragAndDrop: true,// 禁止拖放
        callbacks: {
            onImageUpload: function(files) {
                if (files.length > 1) console.log(files);
                // summerNote编辑器操作本身限制了单次添加图片只能添加一个，so……
                sendFunc(uploadUrl, files[0]).then(responseData => {
                    let imgUrl = responseData.url;
                    $(summerNoteId).summernote('insertImage', imgUrl);
                });
            }
        }
    });
}

