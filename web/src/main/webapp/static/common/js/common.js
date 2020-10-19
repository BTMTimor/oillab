
/*********************************function******************************/

function getUrlPara(url) {
    let param = "";
    let temp = url.lastIndexOf("?")
    if (temp !== -1) {
        param = url.substr(temp + 1);
    }
    return param;
}

function getUriAndPara(url) {
    let uri = "";
    let temp = -1;
    if (0 === url.indexOf("/") && 0 !== url.indexOf("//")) {
        uri = url;
    } else {
        temp = url.indexOf("/", url.indexOf("//") + 2);
        if (temp !== -1) {
            uri = url.substr(temp + 1);
        }
        console.log(url.split("/", 5));
    }
    uri = uri.replace("?", "#");
    console.log("uri = " + uri);
    return uri;
}

/**
 * json数据转表单提交参数，支持两层深度转换（为JFinal定制）
 * @param json json数据
 * @returns {string} 转换后地参数串
 */
function json2QueryParam(json){
    if (!json) return "";
    // 非法数据类型
    let unExceptTypes = new Set(["null", "undefined", "function"]);
    if(unExceptTypes.has(typeof (json))) return "";
    // 非JSONObject
    let types = new Set(["string", "number", "boolean", "symbol"]);
    if(!types.has(typeof (json))) return json;// Object类型

    let paras = "";
    for(let key in json){//i是对象的键值
        let type = typeof(json[key]);
        if (types.has(type)){
            paras += key + "=" + json[key] + "&";
        }else if (type === "object"){
            for(let j in json[key]){ //j是属性名
                paras += key + "." + j + "=" + json[key][j] + "&";//json[i][j]是属性值
            }
        }else{
            //"null" || "undefined" 不做处理
        }
    }
    // length - 1 < 0 ：会返回空字符串""，不会报异常
    paras = paras.substring(0, paras.length - 1);
    return paras;
}

// json2QueryParam({a : 1, b : {c:"hello",d:"test"},e:"54321",f:false});

/**
 * 获取url的参数
 * @param  {[type]} name 参数名称
 * @param  {[type]} url  url，默认为地址栏的url
 * @return {string}      对应的值
 */
function getQueryString(name, url=window.location.href) {
    let reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');

    let index = url.indexOf("?");

    if (index !== -1 && index !== url.length - 1) {
        // TODO test
        history.replaceState(null, "", url.replace("?", "#"));

        let queryString = url.substr(index + 1);
        let r = queryString.match(reg);
        if (r != null) {
            // 先解码，再返回
            return unescape(r[2]);
        }
    }
    return null;
}


function isJSONText(text) {
    return !!/^[\],:{}\s]*$/.test(text.replace(/\\["\\\/bfnrtu]/g, '@').replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']').replace(/(?:^|:|,)(?:\s*\[)+/g, ''));
}

function isJSONObject(object) {
    return typeof(object) == "object" && !object.length
        && Object.prototype.toString.call(object).toLowerCase() === "[object object]";
}

/* 对日期进行格式化，
 * @param date 要格式化的日期
 * @param format 进行格式化的模式字符串
 *     支持的模式字母有：
 *     y:年,
 *     M:年中的月份(1-12),
 *     d:月份中的天(1-31),
 *     h:小时(0-23),
 *     m:分(0-59),
 *     s:秒(0-59),
 *     S:毫秒(0-999),
 *     q:季度(1-4)
 * @return String
 */
function dateFormat(date, format) {
    date = new Date(date);
    let map = {
        "M": date.getMonth() + 1, //月份
        "d": date.getDate(), //日
        "h": date.getHours(), //小时
        "m": date.getMinutes(), //分
        "s": date.getSeconds(), //秒
        "q": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
        let v = map[t];
        if(v !== undefined){
            if(all.length > 1){
                v = '0' + v;
                v = v.substr(v.length-2);
            }
            return v;
        }
        else if(t === 'y'){
            return (date.getFullYear() + '').substr(4 - all.length);
        }
        return all;
    });
    return format;
}

function addFormatToDate(){
    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(H)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd HH:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d H:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.format = function(fmt){
        let o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(let k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length===1)
                    ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }
}

// 获取form表单数据并转化为js对象
function getFormDataToJsObject(formId) {
    let formData = {};
    let formDataArray = $(formId).serializeArray();
    $.each(formDataArray, function () {
        formData[this.name] = this.value;
    });
    return formData;
}

// 获取form表单数据并转化为Entity
function getFormDataToEntity(formId) {
    return new BaseModel(getFormDataToJsObject(formId));
}

// - - - - - - - - - - - - - bootstrap表格相关 - - - - - - - - - - - - - - - -

const queryParams = function (params) {
    return {
        pageNumber: Math.ceil(params.offset / params.limit) + 1,
        pageSize: params.limit,
        sort: params.sort, // 排序列名
        sortOrder: params.order // 排序命令（desc，asc）
    };
};

const bsTableIcons = {
    columns: "glyphicon-list",
    clearSearch: "glyphicon-trash",
    export: "glyphicon-save",
    fullscreen: "glyphicon-fullscreen",
    refresh: "glyphicon-repeat",
    search: "glyphicon-search",
    toggleOn: "glyphicon-align-justify",
    toggleOff: "glyphicon-list-alt",
}

function getCommonBSTablesIcons(){
    return bsTableIcons;
}

function bsTableResponseHandler(result){
    result = Result.fromJSONData(result);
    if(result.success){
        return {
            "total": result.main.totalRow, // 总记录数
            // "pageNumber": result.main.pageNumber,
            // "pageSize": result.main.pageSize,
            // "totalPage" : result.main.totalPage;
            "rows": result.main.list // 数据列表
        };
    }
    alert(result.errorMessage);
    return {};
}

function initBootstrapTable(tableId, toolbarId="", dataUrl) {
    $(tableId).bootstrapTable({
        url: dataUrl,
        method: "GET",
        dataType: "json",
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        uniqueId: "id", //每一行的唯一标识，主键/唯一索引
        undefinedText: "",// 没有数据
        search: false,// 显示搜索框，服务器分页不能使用
        showSearch: false,
        showSearchButton: false, // 搜索按钮
        showSearchClearButton: false, // 清除按钮
        customSort: true,
        // customSearch: true,
        showFullscreen: true,// 全屏按钮
        showPageGo: true, // 页面跳转
        showExport: true, // 导出按钮
        exportTypes: ['json', 'xml', 'csv', 'tsv', 'txt', 'sql', 'doc', 'xls', 'xlsx', 'pdf', 'png'],
        showRefresh: true,// 显示刷新按钮
        showToggle: true,// 是否显示切换视图按钮
        showColumns: true,// 选着显示的列
        showColumnsSearch: true, // 搜索列
        // table-striped表示隔行变色
        classes: "table table-bordered table-striped",
        striped: true, // 隔行变色
        pagination: true,// 分页
        paginationShowPageGo: true,
        // paginationPreText: "上一页",
        // paginationNextText: "下一页",
        pageNumber: 1,// 首次加载的数据页码
        pageSize: 10,// 默认加载数据最大条数
        pageList: [5, 10, 15, 20, 25, 30, 40, 45, 50],
        // clickToSelect: true,// 单机选中行
        sortable: true, // 开启排序
        showMultiSort: true, // 多列排序
        // sortOrder: "asc",// 排序方式（desc，asc）
        // sidePagination: "client",// 由客户端处理分页
        sidePagination: "server",// 由服务端处理分页
        queryParamsType: "limit",
        queryParams: queryParams,
        responseHandler: bsTableResponseHandler,
        toolbar: toolbarId,
        iconSize: "outline",
        icons: bsTableIcons,
    });
}

function initBootstrapTable2(tableId, dataUrl="", columns=[{},{}]){
    $(tableId).bootstrapTable({
        url: dataUrl,
        method: "GET",
        dataType: "json",
        cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        uniqueId: "id", //每一行的唯一标识，主键/唯一索引
        undefinedText: "",// 没有数据
        search: true,// 显示搜索框，服务器分页不能使用
        showSearch: true,
        showSearchButton: true, // 搜索按钮
        showSearchClearButton: true, // 清除按钮
        customSort: true,
        // customSearch: true,
        showFullscreen: true,// 全屏按钮
        showPageGo: true, // 页面跳转
        showExport: true, // 导出按钮
        exportTypes: ['json', 'xml', 'csv', 'tsv', 'txt', 'sql', 'doc', 'xls', 'xlsx', 'pdf', 'png'],
        showRefresh: true,// 显示刷新按钮
        showToggle: true,// 是否显示切换视图按钮
        showColumns: true,// 选着显示的列
        showColumnsSearch: true, // 搜索列

        classes: "table table-bordered table-striped", //table-striped表示隔行变色
        striped: true, // 隔行变色
        pagination: true,// 分页
        paginationShowPageGo: true,
        // paginationPreText: "上一页",
        // paginationNextText: "下一页",
        pageNumber: 1,// 首次加载的数据页码
        pageSize: 10,// 默认加载数据最大条数
        pageList: [5, 10, 15, 20, 25, 30, 40, 45, 50],
        // clickToSelect: true,// 单机选中行
        sortable: true, // 开启排序
        showMultiSort: true, // 多列排序
        // sortOrder: "asc",// 排序方式（desc，asc）
        // sidePagination: "client",// 由客户端处理分页
        sidePagination: "server",// 由服务端处理分页
        queryParamsType: "limit",
        queryParams: queryParams,
        responseHandler: bsTableResponseHandler,
        toolbar: tableId + "ToolBar",
        iconSize: "outline",
        icons: bsTableIcons,
        columns: columns,
    });
}


function initSimpleBootstrapTable(tableId, toolbarId="", dataUrl="", responseHandler=function(res){return ""}) {
    $(tableId).bootstrapTable({
        url: dataUrl,
        method: "GET",
        dataType: "json",
        undefinedText: "",
        striped: true, // 隔行变色
        pagination: true,// 分页
        paginationShowPageGo: true,
        // paginationPreText: "上一页",
        // paginationNextText: "下一页",
        pageNumber: 1,
        pageSize: 10,
        pageList: [1, 5, 10, 15, 20, 25, 30, 40, 45, 50],

        // : true, // 跳转到
        sortable: true,// 可否排序
        sortOrder: "asc",// 排序方式
        queryParamsType: "limit",
        queryParams: queryParams,
        sidePagination: "server",// 由服务端处理分页
        responseHandler: bsTableResponseHandler,
        toolbar: toolbarId,
        iconSize: "outline",
        // 工具栏按钮图标
        icons: bsTableIcons,
    });
}


function getSelectedRows(id) {
    return $(id).bootstrapTable('getAllSelections');
}


function getAllRows(id) {
    return $(id).bootstrapTable('getData');
}


// - - - - - - - - - - - - - 随机函数染相关 - - - - - - - - - - - - - - - -

function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        let r = Math.random() * 16 | 0,
            v = (c === 'x') ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

// - - - - - - - - - - - - - 页面渲染相关 - - - - - - - - - - - - - - - -

function bindMyBtnNav(navId="#my-btn-nav", className=".my-btn", choosed="selected") {
    $(className).on("click", function () {
        let children = $(navId).children(className);
        // 清除所有选中的
        for (let i = 0; i < children.length; i++) {
            $(children[i]).removeClass(choosed);
        }
        // 选中当前点击的
        $(this).addClass(choosed);
    });
}

/**
 * 渲染网页顶部导航栏和网页底部信息
 * @param activeNavItem 被选中的导航栏元素名称
 * @param headerId 导航栏id
 * @param footerId 页脚id
 */


/**
 * 渲染网页顶部导航栏和网页底部信息
 * @param activeNavItem 被选中的导航栏元素名称
 * @param headerId 导航栏id
 * @param footerId 页脚id
 */
function renderHeaderAndFooter(activeNavItem="index", headerId="header", footerId="footer") {
    return new Promise((resolve => {
        resolve(ConfigDao.me.commonInfo);
    })).then(commonInfo => {
        // 渲染网站顶部导航栏
        let renderHeader = new Promise(resove => {
            let result = WebDao.getJSON("/api/v1/modular/nav");
            resove(result.main);
        }).then((navInfo) => {
            let htmlTemp = WebDao.get(commonInfo.template.header);
            return {info:{navs:navInfo, common: commonInfo, selected: activeNavItem}, htmlTemp: htmlTemp};
        }).then((config) => {
            TemplateManager.render(headerId, config.htmlTemp, config);
            $("#" + headerId).html(TemplateManager.render(headerId, config.htmlTemp, config));
        });

        // 渲染网站底部
        let renderFooter = new Promise(resove => {
            resove(WebDao.get(commonInfo.template.footer));
        }).then((htmlTemp) => {
            let config = {info:commonInfo};
            $("#" + footerId).html(TemplateManager.render(footerId, htmlTemp, config));
        });

        return Promise.all([renderHeader, renderFooter]);
    });
}

/**
 * 渲染轮播图
 * @param carouselId 装载轮播图的容器id
 * @param configName 渲染轮播图需要加载的配置
 */
function renderCarousel(carouselId, configName) {
    new Promise(()=>{
        let carouselInfo = Carousel.me.carousels(configName);
        let commonInfo = ConfigDao.me.getCommonInfo();
        let htmlTemp = WebDao.get(commonInfo.carousel.index.template);
        let config = {carousel: carouselInfo, common: commonInfo, randomId: guid()};
        $("#" + carouselId).html(TemplateManager.render(carouselId, htmlTemp, {info: config}));
    });
}

// - - - - - - - - - - - - - 数据提交后处理 - - - - - - - - - - - - - - - -

function processSubmitResult(result, baseMessage, time=1500, refreshParent=true) {
    if (result.success){
        layer.msg(baseMessage + '成功！', {time: 1500});

        // 获取当前页面（弹窗）的id，后关闭本页面
        let index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        // 刷新父页面
        if (refreshParent){
            window.parent.location.reload();
        }
    }else{
        layer.alert(baseMessage + "失败：" + result.errorMessage);
    }
}


function processUpFileResult(result, baseMessage, time=1500, refreshParent=true) {
    if (!!result["url"]){
        layer.msg(baseMessage + '成功！', {time: 1500});
        return true;
    }
    layer.alert(baseMessage + "失败");
    return false;
}

function processUpFileResult2(result, baseMessage, time=1500, refreshParent=true) {
    if (result.success){
        layer.msg(baseMessage + '成功！', {time: 1500});
        return result.main;
    }
    layer.alert(baseMessage + "失败：" + result.errorMessage);
    return false;
}

function commonDeleteAll(bsTableId, success=function(rowsData){}){
    let rows = getSelectedRows(bsTableId);
    if(rows.length > 0){
        layer.confirm("确认这" + rows.length + "条此条记录？", {icon: 3, title:'提示'}, function(index){
            console.log("commonDeleteAll: ", rows);
            success(rows);
        });
    }
}

function commonUpdateAll(rows, success=function(rowsData){}){
    if(rows.length > 0){
        success(rows);
    }
}

function commonSaveAll(rows, success=function(rowsData){}){
    if(rows.length > 0){
        console.log("commonSaveAll: ", rows);
        success(rows);
    }
}

function commonDelete(success=function(rowsData){}){
    layer.confirm("确认删除此条记录？", {icon: 3, title:'提示'}, function(){
        success();
    });
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


function closeCurrentLayer(){
    let index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);//关闭当前页
}


// 刷新iframe
function refreshCurrentTab() {
    let currentIframe = $('#content-main').find("iframe:visible:first")[0];
    currentIframe.contentWindow.location.reload();
}

// 刷新iframe
function refreshCurrentTab2() {
    // let currentIframe = $('#content-main').find("iframe:visible:first")[0];
    // currentIframe.contentWindow.location.reload();
}

let counter = function(){
    let index = 6666;

    function getCounter(){
        return index++;
    }

    return getCounter;
}();


function openNewTab(url, title, document=window.document) {
    return openNewPage(url, title, document);
}

function openNewPage(url, title, document=window.parent.document) {
    if (!url) return;

    let index = counter();
    let tabNav = $(document).find('.J_menuTabs .page-tabs-content');
    let tabContent = $(document).find('.J_mainContent');
    if (url === $(tabNav.find(".J_menuTab.active")[0]).data("id")){
        return ;
    }else{
        let tab = tabNav.find(".J_menuTab").filter((index, item)=> {
            return ($(item).data("id") === url);
        });
        if (tab.length){
            $(tab[0]).addClass("active").siblings(".J_menuTab").removeClass("active");

            let iframe = tabContent.find(".J_iframe").filter((index, item)=> {
                return ($(item).data("id") === url);
            });

            if (iframe.length) {
                $(iframe[0]).show().siblings(".J_iframe").hide();
            }
            return ;
        }
        console.log(tab);
        /*tabNav.find(".J_menuTab").each((index, item)=> {
            if ($(item).data("id") === url) {
                if ($(item).hasClass("active")){
                    processed = true;
                    return false;
                }

                // 当前选中的不是欲选择的选项卡
                $(item).addClass("active").siblings(".J_menuTab").removeClass("active");
                tabContent.find(".J_iframe").each((index, item)=> {
                    if ($(item).data("id") === url) {
                        $(item).show().siblings(".J_iframe").hide();
                        processed = true;
                        return false;
                    }
                })
                return false;
            }
        });*/
    }


    // 隐藏当前 iframe
    tabNav.find(".J_menuTab.active").removeClass("active");
    tabContent.find("iframe").css("display", "none");

    let iframe = '<iframe class="J_iframe" name="iframe' + index + '" width="100%" height="100%" src="' + url + '" frameborder="0" data-id="' + url + '" seamless></iframe>';
    tabNav.append('<a class="active J_menuTab" data-id="' + url + '">' + title + ' <i class="fa fa-times-circle"></i></a>');
    tabContent.append(iframe);
    return false;
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

function isArray(object){
    return Array.isArray(object);
    // return object instanceof Array;
    // return object.constructor === Array;
    // return Object.prototype.toString.call(b).endsWith("Array]");
}

function isJson(object){
    return typeof (object) == "object"
        && Object.prototype.toString.call(object).toLowerCase() === "[object object]"
        && !object.length;
}

function isEmpty(e){
    return null === e || "undefined" === typeof (e) || "" === e;
}

function notEmpty(e){
    return !isEmpty(e);
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
/**
 * 渲染select
 * @param eid 元素id
 * @param dictTypeId 字典类型id
 * @param defaultValue 默认值(请传字符串字面量)
 */
function renderSelect(eid, dictTypeId, defaultValue='1'){
    return new Promise((resolve) => {
        SysDictController.me.renderSelect(eid, dictTypeId);
        resolve(true);
    }).then(()=> {
        if (notEmpty(defaultValue)) $("#" + eid).val(defaultValue);
    });
}

/**
 * 通过链接数据渲染select
 * @param eid 元素id
 * @param url 数据链接
 * @param name 作为选项名称的字段
 * @param value 作为选项值的字段
 * @param defaultValue 默认值(请传字符串字面量)
 */
function renderSelectByUrl(eid, url, name, value="id", defaultValue='1'){
    return new Promise((resolve) => {
        TemplateManager.renderSelectOptionByUrl(eid, url, name, value);
        resolve(true);
    }).then(()=> {
        if (notEmpty(defaultValue)) $("#" + eid).val(defaultValue);
    });
}


/**
 * 通过链接数据渲染select
 * @param eid 元素id
 * @param result 待渲染之数据
 * @param name 作为选项名称的字段
 * @param value 作为选项值的字段
 * @param defaultValue 默认值(请传字符串字面量)
 */
function renderSelectByResult(eid, result, name, value="id", defaultValue='1'){
    return new Promise((resolve) => {
        TemplateManager.renderSelectOptionByResult(eid, result, name, value);
        resolve(true);
    }).then(()=> {
        if (notEmpty(defaultValue)) $("#" + eid).val(defaultValue);
    });
}

/**
 * 通过链接数据渲染select
 * @param eid 元素id
 * @param data 待渲染之数据
 * @param name 作为选项名称的字段
 * @param value 作为选项值的字段
 * @param defaultValue 默认值(请传字符串字面量)
 */
function renderSelectByData(eid, data, name, value="id", defaultValue='1'){
    return new Promise((resolve) => {
        TemplateManager.renderSelectOptionByData(eid, data, name, value);
        resolve(true);
    }).then(()=> {
        if (notEmpty(defaultValue)) $("#" + eid).val(defaultValue);
    });
}


// bs table format
// support
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

function viewImg(imgSrc){
    let view = '\
            <style>.img-preview{padding: 10px;}</style>\
            <div class="row" id="#(imgPreviewContainer)">\
                <div class="col-md-12">\
                    <img src="' + imgSrc + '" class="figure-img img-fluid rounded img-preview" alt="">\
                </div>\
            </div>';
    layer.open({
        type: 1,
        title: "预览",
        maxHeight: 400,
        maxWidth: 500,
        // maxmin: true,
        resize: true,
        content: view
    });
}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
const statusMapping = new Map([
    [0, {class: "btn-default", label: "隐藏"}],
    [1, {class: "btn-success", label: "正常"}],
    [2, {class: "btn-warning", label: "禁用"}],
    [3, {class: "btn-primary", label: "草稿"}],
    [4, {class: "btn-danger", label: "删除"}],
    [5, {class: "btn-info", label: "测试"}]
]);
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

function statusFmt(value){
    let data = statusMapping.get(value);
    if (!data) data = statusMapping.get(5);
    // console.log("statusFmt: " + data);
    return '<span class="btn ' + data.class + ' btn-rounded btn-sm"> '
        + data.label + '</span>';
}

function imgFmt(imgSrc){
    return imgSrc ? '<img src="' + imgSrc +'" alt="图片" onclick="viewImg(\'' + imgSrc + '\')">' : imgSrc;
}

function urlFmt(url){
    return url ? '<a href="' + url +'">'+ url + ' </a>' : url;
}


// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
addFormatToDate();