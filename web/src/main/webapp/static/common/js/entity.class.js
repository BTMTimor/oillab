// 所有entity对象

const Status = {
    hidden: 0, // 隐藏
    normal: 1, // 正常
    forbidden: 2, // 禁用
    temp: 3, // 草稿
    delete: 4, // 删除(假删除)
    test: 5, // 测试
};

// 校验对象
class EntityValidate{
    static messages = {
        en: {
            required: "This field is required.",
            remote: "Please fix this field.",
            email: "Please enter a valid email address.",
            url: "Please enter a valid URL.",
            date: "Please enter a valid date.",
            dateISO: "Please enter a valid date ( ISO ).",
            number: "Please enter a valid number.",
            digits: "Please enter only digits.",
            creditCard: "Please enter a valid credit card number.",
            equalTo: "Please enter the same value again.",
            maxLength:  "Please enter no more than ${para.maxLength} characters." ,
            minLength:  "Please enter at least ${para.minLength} characters." ,
            rangeLength:  "Please enter a value between ${para.minLength} and ${para.maxLength} characters long." ,
            rangeValue:  "Please enter a value between ${para.minValue} and ${para.maxValue}." ,
            maxValue:  "Please enter a value less than or equal to ${para.minValue}." ,
            minValue:  "Please enter a value greater than or equal to ${para.maxValue}."
        },
        zh: {
            required: "这是必填字段",
            remote: "请修正此字段",
            email: "请输入有效的电子邮件地址",
            url: "请输入有效的网址",
            date: "请输入有效的日期",
            dateISO: "请输入有效的日期 (YYYY-MM-DD)",
            number: "请输入有效的数字",
            digits: "只能输入数字",
            creditCard: "请输入有效的信用卡号码",
            equalTo: "你的输入不相同",
            extension: "请输入有效的后缀",
            maxLength: "最多可以输入 ${para.maxLength} 个字符",
            minLength: "最少要输入 ${para.minLength} 个字符",
            rangeLength: "请输入长度在 ${para.minLength} 到 ${para.maxLength} 之间的字符串",
            rangeValue: "请输入范围在 ${para.minValue} 到 ${para.maxValue} 之间的数值",
            maxValue: "请输入不大于 ${para.minValue} 的数值",
            minValue: "请输入不小于 ${para.maxValue} 的数值"
        }
    }

    regx = {
        empty: /^[ \t]+$/,
        numOrLetter: /^[0-9a-zA-Z]+$/,
        numOrLetterOr_: /^\w+$/,
        chineseOrNumOrLetter: /^[0-9a-zA-Z\u4e00-\u9fa5]+$/,
        // 中文名字
        chineseName: /^[\u4e00-\u9fa5]+$/,
        // 只允许英文字母、数字、下划线、以及中划线组成, 开头只能是数字或字母
        email: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9])+(\.[a-zA-Z0-9])+(\.[a-zA-Z0-9]){2,3}$/,
        // 手机号
        tel: /^[1][345678][0-9]{9}$/,
        // 固定电话（座机）
        phone: /^0[0-9]{2,3}-[0-9]{7,8}$/,
        phoneNoArea: /^[1-9][0-9]{5,8}$/,
        phoneWithArea: /^[0][1-9]{2,3}-[0-9]{5,10}$/,
        url: /a/,
        uri: /a/,
        ip: /^([0-9]{1,3}\.){3}[0-9]{1,3}$/,
        port: /a/,
        date: /a/,
        dateISO: /a/,
        number: /^[0-9]+$/,
        decimal: /^[-]?(\d+)[.]+(\d+)$/,
        // 金额格式，最多小数点后三位
        money: /^[0-9]+[.][0-9]{0,3}$/,
        qq: /^[1-9][0-9]{4,10}$/,
    }


    check(rule, value){
        return this.regx[rule].test(value);
    }

    // 只允许英文字母、数字、下划线、以及中划线组成, 开头只能是数字或字母
    checkChineseName(name){
        return this.check("chineseName", name);
    }

    // 只允许英文字母、数字、下划线、以及中划线组成, 开头只能是数字或字母
    checkEmail(email){
        return this.check("email", email);
    }

    // 名称允许汉字、字母、数字，域名只允许英文域名
    checkEmail2(email){
        let emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        return emailReg.test(email);
    }

    // 名称允许汉字、字母、数字，域名只允许英文域名
    checkEmail3(email){
        let emailReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        return emailReg.test(email);
    }

    // 手机号
    checkTel(tel){
        return this.check("tel", tel);
    }

    // 固定电话
    checkPhone(phone){
        return this.check("phone", phone);
    }

    checkUrl(url){

    }

    checkDate(date){

    }

    checkDateISO(dateISO){

    }

    checkQQ(qq){
        return this.check("qq", qq);
    }

    test(){

    }
}

class TestEntity extends BaseModel {
    _test_metaInfo = [
        {
            name: "id", type: "number",
            required: {
                add: true,
                delete: true,
                update: false,
                findById: true,
                find: false
            },
            minValue: 1,
            maxValue: 1000,
        },
        {
            name: "fixed", type: "boolean",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: false,
                find: false
            },
        },
        {
            name: "name", type: "string",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: true,
                find: false
            },
            minLength: 0,
            maxLength: 128,
        },
        {
            name: "tel", type: "tel",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: true,
                find: false
            },
            minLength: 15,
            maxLength: 15,
        },
        {
            name: "ip", type: "ip",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: true,
                find: false
            },
            minLength: 11,
            maxLength: 15,
        },
        {
            name: "idCard", type: "idCard",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: false,
                find: false
            },
            minLength: 0,
            maxLength: 128,
        },
        {
            name: "url", type: "url",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: true,
                find: false
            },
            minLength: 5,
            maxLength: 128,
        },
        {
            name: "uri", type: "uri",
            required: {
                add: true,
                delete: true,
                update: true,
                findById: false,
                find: false
            },
            minLength: 1,
            maxLength: 255,
        },
    ];
}


// article相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Article extends BaseModel{
    constructor(attrs={}) {super(MetaInfo.me.articleArticle, attrs);}

    get baseURI() {return ApiRoute.me.article;}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}

class ArticleController extends Controller{
    static me = ArticleController.from(new Article());

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
}


class ArticleType extends BaseModel {

    constructor(attrs={}) {super(MetaInfo.me.articleType, attrs);}

    get baseURI() {
        return ApiRoute.me.articleType;
    }

}

class ArticleTypeController extends Controller{
    static me = ArticleTypeController.from(new ArticleType());

}

// modular相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Modular extends BaseModel{

    constructor(attrs={}) {super(MetaInfo.me.modularModular, attrs);}

    get baseURI() {return ApiRoute.me.modular;}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    navs(){
        return WebDao.getJSON(this.baseURI + "/nav");
    }

    indexModular(){
        return WebDao.getJSON(this.baseURI + "/indexContent");
    }

    aboutModular(){
        return WebDao.getJSON(this.baseURI + "/about");
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

}

class ModularController extends Controller{
    static me = ModularController.from(new Modular());

    navs(){
        return this._model.navs()["data"]["main"];
    }

    indexModular(){
        return this._model.indexModular();
    }

    aboutModular(){
        return this._model.aboutModular()
    }
}


class ModularType extends BaseModel {

    constructor(attrs={}) {super(MetaInfo.me.modularType, attrs);}

    get baseURI() {
        return ApiRoute.me.modularType;
    }

}

class ModularTypeController extends Controller{
    static me = ModularTypeController.from(new ModularType());

}

// product相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Product extends BaseModel {

    constructor(attrs={}) {super(MetaInfo.me.productProduct, attrs);}

    get baseURI() {
        return ApiRoute.me.product;
    }

    products(categoryId=null, type=null, status=Status.normal){
        return this.findByCondition({
            category: categoryId,
            type: type,
            status: status
        });
    }

    findByCategoryId(categoryId, status=Status.normal){
        return this.findByCondition({
            category: categoryId,
            status: status
        });
    }

    findByType(type, status=Status.normal){
        return this.findByCondition({
            type: type,
            status: status
        });
    }

}

class ProductType extends BaseModel {

    constructor(attrs={}) {super(MetaInfo.me.productType, attrs);}

    get baseURI() {
        return ApiRoute.me.productType;
    }

    types(categoryId=null, status=Status.normal){
        return this.findByCondition({
            category: categoryId,
            status: status
        });
    }

    findByCategoryId(categoryId, status=Status.normal){
        return this.findByCondition({
            category: categoryId,
            status: status
        });
    }

}

class ProductCategory extends BaseModel {
    constructor(attrs={}) {super(MetaInfo.me.productCategory, attrs);}

    get baseURI() {
        return ApiRoute.me.productCategory;
    }

    category(status=Status.normal){
        return this.findByCondition({
            status: status
        });
    }
}

class ProductController extends Controller{
    static me = ProductController.from(new Product());

    findByCategoryId(categoryId){
        return this._model.findByCategoryId(categoryId);
    }

    findByType(type){
        return this._model.findByType(type);
    }
}

class ProductCategoryController extends Controller{
    static me = ProductCategoryController.from(new ProductCategory());

    category(){
        return this._model.category();
    }
}

class ProductTypeController extends Controller{
    static me = ProductTypeController.from(new ProductType());

    findByCategoryId(categoryId){
        return this._model.findByCategoryId(categoryId);
    }

}


// dict相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class SysDictDao extends BaseDao {
    static me = new SysDictDao(ApiRoute.me.sysDict);

    dict(typeId){
        return this.findByCondition({});
    }
}



// config相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class ConfigDao extends BaseDao{
    static BASE_URI = "/api/v1/config";
    static COMMON_INFO = ConfigDao.BASE_URI + "/commonInfo";
    static BASE_PATH = "/config/";
    static me = new ConfigDao(this.BASE_URI, this.BASE_PATH);

    constructor(baseURI=ConfigDao.BASE_URI, basePath=ConfigDao.BASE_PATH) {
        super(baseURI);
        this._basePath = basePath;
        this._cache = new CommonCache();
    }

    getByName(fileName, useCache=true) {
        if (useCache && this._cache.has(fileName)){
            return this._cache.get(fileName);
        }
        // console.log(this.basePath + fileName);
        let result = WebDao.getJSON(this._basePath + fileName);
        if(result.success){
            if (useCache) this._cache.put(fileName, result.main);
            return result.main;
        }
        throw new URIError("can't find the config: " + fileName);
    }

    get commonInfo(){
        let url = this.constructor.COMMON_INFO;
        if(this._cache.has(url)){
            return this._cache.get(url);
        }

        let result = WebDao.getJSON(url);
        console.log(result);
        if(result.success){
            this._cache.put(url, result.main);
            return result.main;
        }
        throw new URIError("can't get the commonInfo.");
    }

}



// 系统字典类型
class SysDictType extends BaseModel{

    constructor(attrs={}) {super(MetaInfo.me.sysDictType, attrs);}

    get baseURI() {return ApiRoute.me.sysDictType;}

    //  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    types(){
        return this.findByCondition({});
    }
}

class SysDictTypeController extends Controller{
    static me = SysDictTypeController.from(new SysDictType());

    testBatchOperation(){
        SysDictTypeController.me.batchAdd([{name:"test_add_001"}, {name: "test_add_010"}]);
        SysDictTypeController.me.batchUpdate([{id:"5FD824215DA0496F9D54A53A50525A22", name:"test_add_100"}, {id: "C7A03C18DD324AE3AEE7C99DD7EC6D6E", name: "test_add_101"}]);
        SysDictTypeController.me.batchDelete([{id:"8B8A21785B78437898BD383B60F0355A"}, {id: "FC3646F0AADA4C098493127439064C42"}]);
    }
}



// 系统字典
class SysDict extends BaseModel {

    constructor(attrs={}) {super(MetaInfo.me.sysDictDict, attrs);}

    get baseURI() {return ApiRoute.me.sysDict;}

    //  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    dict(typeId){
        return this.findByCondition({type: typeId});
    }
}

class SysDictController extends Controller{
    static me = SysDictController.from(new SysDict());

    dict(typeId){
        return this._model.dict(typeId);
    }

    commonRender(eId, typeId, template, others={}){
        let result = this.dict(typeId);
        if(result.success){
            let name = "inputSelectOption";
            let renderResult = TemplateManager.render(name, template, {
                items: result.main,
                others: others
            });
            TemplateManager._renderElement(eId, renderResult);
        }else{
            console.warn(result.message);
        }
    }

    renderSelect(eId, typeId){
        let temp = '\
            {{each items item index}}\n\
            <option value="{{item.value}}">{{item.name}}</option>\n\
            {{/each}}\n';
        this.commonRender(eId, typeId, temp);
    }

    renderCheckboxes(eId, typeId, name){
        let temp = '\
            {{each items item index}}\n\
            <div class="form-check form-check-inline">\n\
                <input type="checkbox" name="{{others.name}}" value="{{item.value}}" class="form-check-input" id="{{others.name}}{{index}}">\n\
                <label for="{{others.name}}{{index}}" class="form-check-label">{{item.name}}</label>\n\
            </div>\n\
            <script>$(\'input[name="#(col.javaFiled)"][value="#[[#(entity]]#.#(col.javaField))"]\').attr("checked", true);</script>\n\
            {{/each}}';
        this.commonRender(eId, typeId, temp, {name: name});
    }

    renderRadios(eId, typeId, name){
        let temp = '\
            {{each items item index}}\n\
            <div class="form-check form-check-inline">\n\
                <input type="radio" name="{{others.name}}" id="{{others.name}}{{index}}" value="{{item.value}}" class="form-check-input">\n\
                <label for="{{others.name}}{{index}}" class="form-check-label">{{item.name}}</label>\n\
            </div>\n\
            {{/each}}\n';
        this.commonRender(eId, typeId, temp, {name: name});
    }

}


// 解决innerHTMl里面嵌入js不执行阿情况
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
/* innerhtml.js
 * Version: 1.9
 * LastModified: 2006-06-04
 * This library is free.  You can redistribute it and/or modify it.
 *
 */
class renderHTML{
    global_html_pool = [];
    global_script_pool = [];
    global_script_src_pool = [];
    global_lock_pool = [];
    innerHtml_lock = null;
    document_buffer = "";

    set_innerHTML(obj_id, html, time=20) {
        if (this.innerHtml_lock == null) {
            this.innerHtml_lock = obj_id;
        }
        else if (typeof(time) == "undefined") {
            (this.global_lock_pool)[obj_id + "_html"] = html;
            window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html']);", 10);
            return;
        }
        else if (this.innerHtml_lock !== obj_id) {
            (this.global_lock_pool)[obj_id + "_html"] = html;
            window.setTimeout("set_innerHTML('" + obj_id + "', global_lock_pool['" + obj_id + "_html'], " + time + ");", 10);
            return;
        }
        function get_script_id() {
            return "script_" + (new Date()).getTime().toString(36)
                + Math.floor(Math.random() * 100000000).toString(36);
        }
        this.document_buffer = "";
        document.write = (str)=> {
            this.document_buffer += str;
        }
        document.writeln = (str)=> {
            this.document_buffer += str + "\n";
        }
        this.global_html_pool = [];
        let scripts = [];
        html = html.split(/<\/script>/i);
        for (let i = 0; i < html.length; i++) {
            global_html_pool[i] = html[i].replace(/<script[\s\S]*$/ig, "");
            scripts[i] = {text: '', src: '' };
            scripts[i].text = html[i].substr(global_html_pool[i].length);
            scripts[i].src = scripts[i].text.substr(0, scripts[i].text.indexOf('>') + 1);
            scripts[i].src = scripts[i].src.match(/src\s*=\s*(\"([^\"]*)\"|\'([^\']*)\'|([^\s]*)[\s>])/i);
            if (scripts[i].src) {
                if (scripts[i].src[2]) {
                    scripts[i].src = scripts[i].src[2];
                }
                else if (scripts[i].src[3]) {
                    scripts[i].src = scripts[i].src[3];
                }
                else if (scripts[i].src[4]) {
                    scripts[i].src = scripts[i].src[4];
                }
                else {
                    scripts[i].src = "";
                }
                scripts[i].text = "";
            }
            else {
                scripts[i].src = "";
                scripts[i].text = scripts[i].text.substr(scripts[i].text.indexOf('>') + 1);
                scripts[i].text = scripts[i].text.replace(/^\s*<\!--\s*/g, "");
            }
        }
        let s;
        if (typeof(time) == "undefined") {
            s = 0;
        }else {
            s = time;
        }
        let script, add_script, remove_script;
        for (let i = 0; i < scripts.length; i++) {
            let add_html = "document_buffer += global_html_pool[" + i + "];\n";
            add_html += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
            script = document.createElement("script");
            if (scripts[i].src) {
                script.src = scripts[i].src;
                if (typeof((this.global_script_src_pool)[script.src]) == "undefined") {
                    (this.global_script_src_pool)[script.src] = true;
                    s += 2000;
                }
                else {
                    s += 10;
                }
            }
            else {
                script.text = scripts[i].text;
                s += 10;
            }
            script.defer = true;
            script.type =  "text/javascript";
            script.id = get_script_id();
            (this.global_script_pool)[script.id] = script;
            add_script = add_html;
            add_script += "document.getElementsByTagName('head').item(0)";
            add_script += ".appendChild(global_script_pool['" + script.id + "']);\n";
            window.setTimeout(add_script, s);
            remove_script = "document.getElementsByTagName('head').item(0)";
            remove_script += ".removeChild(document.getElementById('" + script.id + "'));\n";
            remove_script += "delete global_script_pool['" + script.id + "'];\n";
            window.setTimeout(remove_script, s + 10000);
        }
        let end_script = "if (document_buffer.match(/<\\/script>/i)) {\n";
        end_script += "set_innerHTML('" + obj_id + "', document_buffer, " + s + ");\n";
        end_script += "}\n";
        end_script += "else {\n";
        end_script += "document.getElementById('" + obj_id + "').innerHTML = document_buffer;\n";
        end_script += "innerhtml_lock = null;\n";
        end_script += "}";
        window.setTimeout(end_script, s);
    }
}


// template相关
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class TemplateDao extends BaseDao{
    constructor(baseUri) {
        super();
        this._baseURI = baseUri;
    }

    get baseURI() {
        return this._baseURI;
    }
}

class TemplateManager {
    static baseURI = "/api/v1/template";
    static _templateCache = {"NoCache": ""};
    static templateDao = new TemplateDao(this.baseURI);
    static _renderElement = function (id, content=null) {
        if (typeof(content) !== undefined && content !== null){
            $("#"+id).html(content);
            /*let element = document.getElementById(id);
            if (element !== null){
                // new renderHTML().set_innerHTML(id, content);
                // element.innerHTML = content;
            }*/
        }
    }

    static addDateFormatToTemplate = function(){
        if (!template) return;
        // common.js : dateFormat
        template.defaults.imports.dateFormat = function(date, format) {
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
        ;
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    static renderToElement(eid, queryParaEntity, data){
        // 先判断是否已缓存模板，若已缓存，则从缓存里取
        if (TemplateManager.hasCacheTemplate(queryParaEntity.name)){
            this._renderElement(eid, this.render(queryParaEntity.name, data));
            return true;
        }

        // 没有缓存
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        let result = this.templateDao.findOneByCondition(queryParaEntity);
        if (result === "") throw new Error("未找到该模板");

        let temp = result["data"]["main"];
        this._renderElement(eid, this.render(temp.name, temp.template, data));
        return result;
    }

    static renderByEId(id, data, cache=true){
        if (id){
            let element = document.getElementById(id);
            let templateName = cache ? id : "NoCache";
            this._renderElement(id, this.render(templateName, element.innerHTML, data))
        }
    }

    static renderByScriptId(scId, id="", data, cache=true){
        let renderHtml = "";
        if (scId){
            let sc = document.getElementById(scId);
            if (sc && sc.innerText){
                let templateName = cache ? ("#" + id ? id : "") : "NoCache";
                renderHtml = this.render(templateName, sc.innerText, data);
                // console.log("renderHtml: ", renderHtml);
                this._renderElement(id, renderHtml);
            }
        }
        return renderHtml;
    }

    static _getPagination(pageData){
        let pagination = {
            url: pageData.url,
            firstPage: 1,// 有些地方0为第一页
            pageSize: pageData.pageSize ? pageData.pageSize : 10,
            totalPage: pageData.totalPage ? pageData.totalPage : 1,
            totalRow: pageData.totalRow ? pageData.totalRow : 1,
            pageNumber: pageData.pageNumber ? pageData.pageNumber : 1,
            pageNumbers: [1, 2, 3, 4, 5, -1, 97, 98, 99],
            hasMorePages: false,
        };
        let pages = [];
        let temp = pagination.totalPage - pagination.firstPage + 1;
        temp = (temp >= 10) ? 10 : temp;
        if (9 >= temp || 10 >= pagination.totalPage){
            // console.log(temp);
            // 填充页码（temp in [0, 9]）
            for (let i = 0; i < temp; i++) {
                pages[i] = i + 1;
            }
            pagination.pageNumbers = pages;
            return pagination;
        }

        // 10 === temp
        const aSize = 4;
        // 不在结尾附近（前面或中间）

        let start1 = pagination.pageNumber > 3
            ? pagination.pageNumber - 2 : pagination.firstPage;
        let end1 = start1 + aSize < pagination.totalPage ? start1 + aSize : pagination.totalPage;
        let start2 = (end1 + aSize < pagination.totalPage ? pagination.totalPage - aSize : end1) + 1;
        if(pagination.pageNumber >= pagination.totalPage - aSize) {
            start2 = pagination.totalPage - aSize;
            start1 = 1;
            end1 = pagination.totalPage - start2;
        }
        pagination.hasMorePages = (start2 !== end1);
        console.log(temp, start1, end1, start2, temp - 1);

        let i, j;
        // 填充前半部分的页码（共5页）
        for (i = 0; i <= end1 - start1; i++) {
            pages[i] = start1 + i;
        }
        if (start2 !== end1) pages[i++] = -1;
        // 填充后半部分的页码
        if(pagination.totalPage - start2 > 0) {
            for (j = 0; j <= pagination.totalPage - start2; i++, j++) {
                pages[i] = start2 + j;
            }
        }
        pagination.pageNumbers = pages;
        return pagination;
    }

    static renderPagination(eid, pageData){
        let data = {pagination: this._getPagination(pageData)};
        // console.log("pagination: ", data);
        let template = WebDao.get("/template/pagination");
        return this._renderElement(eid, this.render(eid, template, data));
    }

    static _toOptionData(items, name, value){
        let data = [];
        for (let i = 0; i < items.length; i++) {
            data.push({name: items[i][name], value: items[i][value]});
        }
        return data;
    }

    static renderSelectOptionByUrl(id, url, name="name", value="value"){
        let result = WebDao.getJSON(url);
        if(result.success){
            let data = this._toOptionData(result.main, name, value);
            this.renderSelectOption(id, data);
        }
    }

    static renderSelectOptionByResult(id, result, name="name", value="value"){
        if(result.success){
            let data = this._toOptionData(result.main, name, value);
            this.renderSelectOption(id, data);
        }
    }

    static renderSelectOptionByData(id, dataList, name="name", value="value"){
        let data = this._toOptionData(dataList, name, value);
        this.renderSelectOption(id, data);
    }

    static renderSelectOption(id, items){
        let temp = '\
            {{each items item index}}\n\
            <option value="{{item.value}}">{{item.name}}</option>\n\
            {{/each}}\n';
        let content = this.render("renderSelectOption", temp, {items: items});
        this._renderElement(id, content);
    }

    static render(templateName="NoCache", templateContent="", data){
        // 判断是否已缓存模板
        if (TemplateManager.hasCacheTemplate(templateName)){
            // run template function
            return this._templateCache[templateName](data);
        }else{
            let temp = template.compile(templateContent);
            // 判断是否需要缓存
            if (temp && templateName !== "NoCache") {
                this._templateCache[templateName] = temp;
            }
            return temp(data);
        }
    }

    static hasCacheTemplate(templateName){
        if (templateName !== "NoCache") {
            return this._templateCache[templateName];
        }
        return false;
    }

}

// 添加格式化日期函数到template
TemplateManager.addDateFormatToTemplate();
