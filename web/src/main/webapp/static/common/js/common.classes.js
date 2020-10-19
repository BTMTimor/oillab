// 依赖与： "/template/default/js/common.js";

class BaseRoute {
    _route = {};

    constructor(route = "") {
        if (route !== ""){
            this._route = route;
        }
    }

    getRoute(name=""){
        return this._getRoute(this._route, name);
    }

    _getRoute(routes, name="this"){
        if (name === "this"){
            return routes;
        }else if (-1 === name.indexOf(".")){
            return routes[name];
        }else {
            // xx.yy.zz
            let names = name.split(".");
            let route = routes;
            for (let temp in names) {
                route = route[names[temp]];
            }
            return route;
        }
    }

}

/**
 * API 路由配置中心，方便API统一管理及后期维护
 */
class ApiRoute extends BaseRoute {
    static route = {
        modular: {
            modular: "/api/v1/modular",
            type: "/api/v1/modular/type",
        },
        article: {
            article: "/api/v1/article",
            type: "/api/v1/article/type",
        },
        carousel: "/api/v1/carousel",
        product: {
            base: "/api/v1/product",
            type: "/api/v1/product/type",
            category: "/api/v1/product/category",
        },
        sys:{
            dict: {
                base: "/api/v1/sys/dict",
                type: "/api/v1/sys/dict/type",
            },
        },
        gen: {
            table: {
                base: "/api/v1/gen/table",
                col: "/api/v1/gen/table/col"
            },
        },
        template: "/api/v1/template"
    };
    static me = new ApiRoute();

    constructor(routes = ApiRoute.route) {
        super(routes);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    get modular() {
        return this.getRoute("modular.modular");
    }

    get modularType() {
        return this.getRoute("modular.type");
    }

    get article() {
        return this.getRoute("article.article");
    }

    get articleType() {
        return this.getRoute("article.type");
    }

    get carousel() {
        return this.getRoute("carousel");
    }

    get product() {
        return this.getRoute("product.base");
    }

    get productType() {
        return this.getRoute("product.type");
    }

    get productCategory() {
        return this.getRoute("product.category");
    }

    get sysDict() {
        return this.getRoute("sys.dict.base");
    }

    get sysDictType() {
        return this.getRoute("sys.dict.type");
    }

    get template() {
        return this.getRoute("template");
    }

    get genTable() {
        return this.getRoute("gen.table.base");
    }

    get genTableCol() {
        return this.getRoute("gen.table.col");
    }
}

class Storage {
    static me = new Storage();

    has(key){
        return Boolean(localStorage.getItem(key));
    }

    get(key){
        return localStorage.getItem(key);
    }

    put(key, value){
        localStorage.setItem(String(key), String(value));
    }

    remove(key){
        localStorage.remove(key);
    }

    clear(){
        localStorage.clear();
    }

    size(){
        return localStorage.length;
    }

    foreach(callback=function(value, key){}){
        for (let i = 0; i < localStorage.length; i++) {
            let key = this.key(i);
            callback(this.get(key), key);
        }
    }
}

class VarCache {
    constructor() {
        this._cache = new Map();
    }

    has(key){
        return this._cache.has(key);
    }

    get(key){
        return this._cache.get(key);
    }

    put(key, value){
        this._cache.set(key, value);
    }

    remove(key){
        this._cache.remove(key);
    }

    clear(){
        this._cache.clear();
    }

    size(){
        return this._cache.size;
    }

    foreach(callback=function(value, key){}){
        this._cache.forEach(callback);
    }
}

// 缓存类
class CommonCache{

    constructor(useStorage=false) {
        if(useStorage && this.supportLocalStorage()){
            this._cache = new Storage();
        }else{
            this._cache = new VarCache();
        }
    }

    supportLocalStorage(){
        return (typeof(Storage) !== "undefined");
    }

    has(key){
        return this._cache.has(key);
    }

    get(key){
        return this._cache.get(key);
    }

    put(key, value){
        this._cache.put(key, value);
    }

    remove(key){
        this._cache.remove(key);
    }

    clear(){
        this._cache.clear();
    }

    size(){
        this._cache.size();
    }
}




// web、model与数据交换
// - - - - - - - - - - - - - - - - - - - - - - - - - - - -

/**
 * 返回数据结果的对象
 */
class Result {
    static NEED_LOGIN = 101;

    constructor(code, data, message) {
        // 状态码
        this._code = code;
        // 数据实体
        this._data = data;
        // 代码含义
        this._message = message;
    }

    static fromJSONData(JSONData){
        return new Result(JSONData.code, JSONData.data, JSONData.message);
    }

    get code() {
        return this._code;
    }

    get data() {
        return this._data;
    }

    get main() {
        return this._data.main;
    }

    get message() {
        return this._message;
    }

    get success(){
        // Math.ceil(count / pagesize); //向上整除 4/3=2;
        // Math.floor(count / pagesize); //向下整除 4/3=1;
        // Math.round(5/2);//四舍五入     parseInt(5/2);//丢弃小数部分,保留整数部分
        return (2 === Math.floor(this.code / 100));
    }

    get errorMessage(){
        if(!this.success){
            let message = this.message;
            if (this.main) message += ": " + this.main;
            return message;
        }
        return "";
    }

    get successMessage(){
        if(this.success){
            let message = this.message;
            if (this.main) message += ": " + this.main;
            return message;
        }
        return "";
    }

    get needLogin(){
        return this.constructor.NEED_LOGIN === this.code;
    }
}

/**
 * 网络层对象(同步)
 * 主要作用：封装网络数据交换，方便二次开发及模块化开发
 */
class WebDao {
    // 服务器地址项目，如http:127.0.0.1:8080/celebrate/
    static server = '';
    // static server = 'http://localhost:8083/';

    static ajax(url, option){
        option["async"] = false;
        let response = $.ajax(url, option)

        let result = "";
        if (200 === response.status){
            result = response.responseText;
        }
        return result;
    }

    static simpleAjax(type, url, data=""){
        let response = $.ajax(url, {type: type, async: false, data: data, accept:"application/json"});

        let result = "";
        if (200 === response.status){
            result = Result.fromJSONData(JSON.parse(response.responseText));
        }
        return result;
    }

    // 同步get
    static get(url){
        return this.ajax(url, {type: "GET"});
    }

    // 同步get
    static getJSON(url){
        return this.simpleAjax("GET", url);
    }

    /**
     * 同步post
     * @param url url
     * @param data 数据
     * @returns json
     */
    static post(url, data){
        return this.simpleAjax("POST", url, json2QueryParam(data));
    }

    // 同步post
    static postFile(url, formData){
        let response = $.ajax({
            type: "POST",
            url: url,
            async: false,
            data: formData,
            datatype: "json",
            contentType: false,
            cache: false,
            processData: false
        });

        let result = "";
        console.log(typeof(response.responseText));
        if (200 === response.status && typeof(response.responseText) !== "object"){
            // result = Result.fromJSONData(JSON.parse(response.responseText));
            result = JSON.parse(response.responseText);
        }
        return result;
    }

    // 同步post
    static postJSON(url, jsonData){
        let response = $.ajax({
            type: "POST",
            url: url,
            async: false,//关键是这个参数 是否异步请求=>false:使用同步请求
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify(jsonData)
        });

        let result = "";
        if (200 === response.status){
            result = Result.fromJSONData(JSON.parse(response.responseText));
        }
        return result;
    }

    // 同步put
    static put(url, data){
        return this.simpleAjax("PUT", url, data);
    }

    // 同步delete
    static delete(url, data){
        return this.simpleAjax("DELETE", url, data);
    }

}

/**
 * Dao对象(同步)
 * 主要作用：封装基础crud网络数据交换，方便二次开发及模块化开发
 */
class BaseDao {
    constructor() {}

    // - - - - - - - - - - - - - - crud - - - - - - - - - - - - - - - - - - -

    // 通过id获取
    getById(id) {
        let url = this.baseURI + "/get?id=" + id;
        return WebDao.getJSON(url);
    }

    // 添加
    add(entity) {
        let url = this.baseURI + "/add";
        return WebDao.post(url, entity);
    }

    // 更新
    update(entity) {
        let url = this.baseURI + "/update";
        return WebDao.post(url, entity)
    }

    // 删除
    deleteById(id) {
        let url = this.baseURI + "/delete?id=" + id;
        return WebDao.getJSON(url);
    }

    // 删除
    fackDeleteById(id) {
        /*let url = this.baseURI + "/delete?id=" + id;
        return WebDao.get(url);*/
    }

    // - - - - - - - - - - - - - - - batch operation- - - - - - - - - - - - - - - - - -

    // 批量添加
    batchAdd(entityList){
        let url = this.baseURI + "/batchAdd";
        return WebDao.postJSON(url, entityList);
    }

    // 批量修改
    batchUpdate(entityList){
        let url = this.baseURI + "/batchUpdate";
        return WebDao.postJSON(url, entityList);
    }

    // 批量删除
    batchDelete(idList){
        let url = this.baseURI + "/batchDelete";
        return WebDao.postJSON(url, idList);
    }

    // - - - - - - - - - - - - - - - 条件查找 - - - - - - - - - - - - - - - - - -

    findByCondition(queryParam){
        let url = this.baseURI + "/list";
        return WebDao.post(url, queryParam);
    }

    findOneByCondition(queryParam){
        let url = this.baseURI + "/findOne";
        return WebDao.post(url, queryParam);
    }

    findPageByCondition(queryParam){
        let url = this.baseURI + "/find";
        return WebDao.post(url, queryParam);
    }

    // - - - - - - - - - - - - - 自动生成的方法 - - - - - - - - - - - - - -

    get baseURI() {
        throw Error('unimplemented abstract method');
    }
}

/**
 * DDD对象(同步)
 */
class BaseModel extends BaseDao{
    CHECK_FOR_ADD = "add"; CHECK_FOR_DELETE = "delete";
    CHECK_FOR_GET = "get"; CHECK_FOR_UPDATE = "update";
    CHECK_FOR_LIST = "list"; CHECK_FOR_FIND = "find";
    CHECK_SUCCESS = ""; CHECK_FOR_FIND_ONE = "findOne";
    static ID_RULE = {
        add: false, delete: true, update: true, findById: true,
        find: false, findOne: false, list: false,
        batchAdd: false, batchUpdate: true, batchDelete: true,
    };
    static ADD_AND_UPDATE = {
        add: true, delete: false, update: true, findById: false,
        find: false, findOne: false, list: false,
        batchAdd: false, batchUpdate: false, batchDelete: false,
    };
    static NOT_REQUIRED = {
        add: false, delete: false, update: false, findById: false,
        find: false, findOne: false, list: false,
        batchAdd: false, batchUpdate: false, batchDelete: false,
    };
    static metaInfoRequired = new Map([
        ["ID_RULE", BaseModel.ID_RULE],
        ["ADD_AND_UPDATE", BaseModel.ADD_AND_UPDATE],
        ["NOT_REQUIRED", BaseModel.NOT_REQUIRED]
    ]);
    _abstractClass = false;
    _metaInfo;
    // check
    necessaryAttrs = new Map();
    stringTypeCheck = new Set(["string", "tel", "ip", "idCard", "url", "uri"]);
    numberTypeCheck = new Set(["short", "int", "long", "float", "double", "bigint", "bigDecimal"]);

    constructor(metaInfo=[], attrs={}){
        super();
        if (this._abstractClass && new.target === BaseModel) {
            throw new Error('本抽象类不能实例化');
        }

        // 也可以选用Map
        this._attrs = attrs;
        this.init(metaInfo);
    }

    init(metaInfo){
        let clazz = this.constructor;
        for (let i in metaInfo) {
            let colInfo = metaInfo[i];
            let key = colInfo["name"];
            let value = colInfo["required"];
            if(clazz.metaInfoRequired.has(value)){
                value = clazz.metaInfoRequired.get(value);
            }
            colInfo["required"] = value;
            this.necessaryAttrs.set(key, value);
        }
        this._metaInfo = metaInfo;
    }

    // 通过formId获取form data作为model的attrs
    static fromForm(formId){
        let formDataArray = $(formId).serializeArray();
        let entity = new this();
        if (formDataArray.length > 0){
            for (let i in formDataArray) {
                let data = formDataArray[i];
                entity.setAttr(data.name, data.value);
            }
        }
        return entity;
    }

    static fromObject(object={}){
        let entity = new this();
        entity._attrs = entity.filterUnKnowAttrs(object);
        return entity;
    }

    get metaInfo() {return this._metaInfo;}

    /*get metaInfo(){
        throw Error('unimplemented abstract method');
    };*/

    get attrs(){
        return this._attrs;
    }

    isAttr(name){
        return this.necessaryAttrs.has(name);
    }

    getAttr(name){
        // return (this._attrs[name] ? this._attrs[name] : "");
        return this._attrs[name];
    }

    setAttr(name, value){
        /*if(!this.isAttr(name)){
            throw new Error("unKnow attribute: " + name);
        }*/
        this._attrs[name] = value;
    }

    isNecessary(name, type="") {
        console.log('(name = ' + name + ', type=' + type + ')');
        if(this.necessaryAttrs.has(name)){
            return !!this.necessaryAttrs.get(name)[type];
        }
        return false;
    }

    removeUnNecessaryAttrs(type=""){
        for (let i in this.metaInfo) {
            let colInfo = this.metaInfo[i];
            if (!colInfo.required[type] && this.getAttr(colInfo.name)){
                delete this._attrs[colInfo.name];
            }
        }
    }

    removeNullAttrs(){
        let object = this._attrs;
        for (let key in object) {
            // 为非法属性或者null/undefined，则删除该属性
            if(!this.isAttr(key) || (typeof(object[key]) === "object" && !object[key])){
                delete object[key];
            }
        }
    }

    removeUnKnowAttrs(){
        return this._attrs = this.filterUnKnowAttrs(this.attrs);
    }

    filterUnKnowAttrs(object={}){
        let attributes = {};
        for (let key in object) {
            if(this.isAttr(key)){
                attributes[key] = object[key];
            }
        }
        return attributes;
    }

    filterToAdd(){
        return this.filterUnKnowAttrs(this.attrs);
    }

    filterToUpdate(){
        return this.filterUnKnowAttrs(this.attrs);
    }

    filterToDelete(){
        let type = this.CHECK_FOR_DELETE;
        for (let key in this.attrs) {
            if (!this.isNecessary(key, type)){
                delete this._attrs[key];
            }
        }
        return this.attrs;
    }

    // crud method
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    save(){
        // console.log(this.filterUnKnowAttrs(this.attrs));
        return super.add(this.filterUnKnowAttrs(this.attrs));
    }

    update(){
        // console.log(this.filterUnKnowAttrs(this.attrs));
        return super.update(this.filterUnKnowAttrs(this.attrs));
    }

    deleteById(id) {
        return super.deleteById(id);
    }

    // check method
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    _isUnchecked(value){
        return "undefined" === typeof(value) || null === value || "" === value;
    }

    _checkRange(range, minValue=0, maxValue=Number.MAX_SAFE_INTEGER){
        let rangeValue = "";
        if(range && range.trim().length > 1){
            rangeValue = range.trim();
            if(rangeValue.includes(",")){
                if(rangeValue.startsWith(",")){
                    rangeValue = minValue + rangeValue;
                }
                if(rangeValue.endsWith(",")){
                    rangeValue += maxValue;
                }
                let result = rangeValue.split(",");
                rangeValue = Number.parseInt(result[0]) + "," + Number.parseInt(result[1]);
            }else{
                rangeValue = minValue + "," + Number.parseInt(rangeValue);
            }
        }
        return rangeValue;
    }

    _defaultProcess(colInfo={}){
        if (this.stringTypeCheck.has(colInfo.type)){
            // (8)=>(0, 8), (x, x)=>(x, x), (8, )=>(8, +), (, 8)=>(0, 8)
            let rangeLength = colInfo.rangeLength;
            if(rangeLength && (rangeLength = this._checkRange(rangeLength))){
                let result = rangeLength.split(",");
                colInfo.minLength = Number.parseInt(result[0]);
                colInfo.maxLength = Number.parseInt(result[1]);
            }else{
                colInfo.minLength = colInfo.minLength ? colInfo.minLength : 0;
                colInfo.maxLength = colInfo.maxLength ? colInfo.maxLength : Number.MAX_SAFE_INTEGER;
            }
        }else if (this.numberTypeCheck.has(colInfo.type)){
            let rangeValue = colInfo.rangeValue;
            if(rangeValue && (rangeValue = this._checkRange(rangeValue))){
                let result = rangeValue.split(",");
                colInfo.minValue = Number.parseInt(result[0]);
                colInfo.maxValue = Number.parseInt(result[1]);
            }else {
                colInfo.minValue = colInfo.minValue ? colInfo.minValue : Number.MIN_SAFE_INTEGER;
                colInfo.maxValue = colInfo.maxValue ? colInfo.maxValue : Number.MAX_SAFE_INTEGER;
            }
        }
        if(!colInfo["label"]) colInfo["label"] = "";
    }

    /**
     * 通用参数校验，目前仅支持string和number的校验
     * @param type 校验类型：add、update、delete、findById、find、list
     * @param otherCheck 可提供其他校验
     * @returns {string} 错误信息
     * @private
     */
    _commonCheck(type, otherCheck=function (name, value) {return "";}){
        console.log("metaInfo: ", this.metaInfo);
        // console.log("attrs: ", this.attrs);
        for (let i in this.metaInfo) {
            // 校验规则元信息
            let colInfo = this.metaInfo[i];
            let value = this.getAttr(colInfo.name);
            // 参数过滤：使用默认值
            this._defaultProcess(colInfo);

            // console.log(colInfo.name, ": ", value, "(", this._isUnchecked(value), ")");
            // 必填, 校验是否有值，并处理无值情况
            if((colInfo.required[type] && this._isUnchecked(value))/* || (!colInfo.required.type && value)*/){
                if (this.stringTypeCheck.has(colInfo.type)){
                    return colInfo.label + "的长度必须在" + colInfo.minLength + "到" + colInfo.maxLength + "之间";
                }else if (this.numberTypeCheck.has(colInfo.type)) {
                    return colInfo.label + "的请必须在" + colInfo.minValue + "到" + colInfo.maxValue + "之间";
                }else{
                    return "请填写" + colInfo.label;
                }
            }

            // 必填有值或非必填有值；校验
            if(!this._isUnchecked(value)){
                // 字符串长度校验
                if (this.stringTypeCheck.has(colInfo.type)) {
                    // 字段长度校验
                    if (colInfo.maxLength < value.length) {
                        return colInfo.label + "的长度必须小于" + colInfo.maxLength;
                    }else if(colInfo.minLength > value.length){
                        return colInfo.label + "的长度必须大于" + colInfo.minLength;
                    }

                    // 对应类型正则及其他校验
                    if ("tel" === colInfo.type){

                    }
                }

                // 数值校验
                if (this.numberTypeCheck.has(colInfo.type)){
                    if(colInfo.maxValue < Number(value)){
                        return colInfo.label + "的值必须小于" + colInfo.maxValue;
                    }else if(colInfo.minValue > Number(value)){
                        return colInfo.label + "的值必须大于" + colInfo.minValue;
                    }
                }

            }

        }
        return this.CHECK_SUCCESS;
    }


    checkForGet(){
        return this._commonCheck(this.CHECK_FOR_GET);
    }

    checkForAdd(){
        return this._commonCheck(this.CHECK_FOR_ADD);
    }

    checkForDelete(){
        return this._commonCheck(this.CHECK_FOR_DELETE);
    }

    checkForUpdate(){
        return this._commonCheck(this.CHECK_FOR_UPDATE);
    }

    checkForList(){
        return this._commonCheck(this.CHECK_FOR_LIST);
    }

    checkForFind(){
        return this._commonCheck(this.CHECK_FOR_FIND);
    }

    checkForFindOne(){
        return this._commonCheck(this.CHECK_FOR_FIND_ONE);
    }
}

// model包装器，过滤其中一些容易引起误解的方法方法
class ModelWrapper{
    _model;

    constructor(model) {
        // throw new Error("can't Instantiate.");
        if(!this.isModel(model)){
            throw new Error("can't parse model. model must instanceof BaseModel.");
        }
        this._model = model;
    }

    isModel(model){
        return (model instanceof BaseModel);
    }

    static from(model){
        return new ModelWrapper(model);
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 通过id查找数据
    getById(id){
        return this._model.getById(id);
    }

    add(model){
        return model.save();
    }

    update(model){
        return model.update();
    }

    // 通过id删除数据
    deleteById(id){
        return this._model.deleteById(id);
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 批量添加数据
    batchAdd(entityList){
        return this._model.batchAdd(entityList);
    }

    // 批量修改数据
    batchUpdate(entityList){
        return this._model.batchUpdate(entityList);
    }

    // 批量删除数据
    batchDelete(entityList){
        return this._model.batchDelete(entityList);
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 通过条件查询所有数据
    findByCondition(conditionPara){
        return this._model.findByCondition(conditionPara);
    }

    // 通过条件查询一条数据
    findOneByCondition(conditionPara){
        return this._model.findOneByCondition(conditionPara);
    }

    // 通过条件查询一页数据
    findPageByCondition(conditionPara){
        return this._model.findPageByCondition(conditionPara);
    }
}

// controller封装常见请求和错误提示&处理
class Controller {
    CHECK_FOR_ADD = "checkForAdd";
    CHECK_FOR_UPDATE = "checkForUpdate";
    CHECK_FOR_GET = "checkForGet";
    CHECK_FOR_DELETE = "checkForDelete";
    CHECK_FOR_LIST = "checkForList";
    CHECK_FOR_FIND = "checkForFind";
    CHECK_FOR_FIND_ONE = "checkForFindOne";
    _model;

    constructor(model) {
        this.checkModel(model);
        this._model = model;
    }

    checkModel(model){
        if(!this.isModel(model)){
            throw new Error("can't parse model. model must instanceof BaseModel.");
        }
    }

    isModel(model){
        return (model instanceof BaseModel);
    }

    // 后者的类型是否与前者一致
    checkSameClassInstance(clazz, clazz2){
        if(clazz.constructor !== clazz2.constructor){
            throw new Error("the model type must b " + clazz.constructor.name);
        }
    }

    static from(model){
        if(model instanceof BaseModel){
            return new this(model);
        }
        throw new Error("can't parse model. model must instanceof BaseModel.");
    }

    toModel(object){
        this._model.constructor.fromAttrsToDelete(object);
    }

    commonCheck(model, funcName="checkForXXX", showMsg=true){
        this.checkSameClassInstance(this._model, model);

        // 校验model
        let message;
        if ((message = model[funcName]())){
            if (showMsg) layer.alert(message);
            return false;
        }
        return true;
    }

    commonCheckAll(models, funcName="checkForXXX"){
        if(models && models.length > 0){
            let message;
            for (let i = 0; i < models.length; i++) {
                let model = models[i];
                this.checkSameClassInstance(this._model, model);

                // 校验model
                if ((message = model[funcName]())){
                    layer.alert("At models[" + i + "]: " + message);
                    return false;
                }
            }
        }
        return true;
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 通过id查找数据
    getById(id){
        return this._model.getById(id);
        /*let result = this._model.getById(id);

        if (result.success) {
            return new this._model.constructor(result.data.main);
        }else{
            this.processError("查找失败：", );
        }*/
    }

    // 通过id查找数据
    add(model){
        if(this.commonCheck(model, this.CHECK_FOR_ADD)){
            this.processAddResult(model.save());
        }
    }

    // 通过id查找数据
    addByForm(formId="#xxx"){
        let model = this._model.constructor.fromForm(formId);
        if(this.commonCheck(model, this.CHECK_FOR_ADD)){
            this.processAddResult(model.save());
        }
    }

    // 通过id删除数据
    updateByForm(formId="#xxx"){
        let model = this._model.constructor.fromForm(formId);
        if(this.commonCheck(model, this.CHECK_FOR_UPDATE)){
            this.processUpdateResult(model.update());
        }
    }

    // 通过id删除数据
    update(model){
        if(this.commonCheck(model, this.CHECK_FOR_UPDATE)){
            this.processUpdateResult(model.update());
        }
    }

    // 通过id删除数据
    deleteById(id){
        this.processDeleteResult(this._model.deleteById(id));
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 批量添加数据
    batchAdd(rows, refresh=true){
        if (rows.length < 1) return;

        let models = new Array(rows.length);
        for (let i = 0; i < rows.length; i++) {
            models[i] = this._model.constructor.fromObject(rows[i]);
        }
        console.log(models);
        let result = this._model.batchAdd(models);
        this.processBatchOperationResult(result, refresh);
    }

    // 批量修改数据
    batchUpdate(rows, refresh=true){
        if (rows.length < 1) return;
        console.log("changed rows data: \n", rows);
        console.log("metaInfo: \n", this._model._metaInfo);

        // transfer
        let models = new Array(rows.length);
        for (let i = 0; i < rows.length; i++) {
            models[i] = this._model.constructor.fromObject(rows[i]);
        }

        // check
        if(!this.commonCheckAll(models, this.CHECK_FOR_UPDATE)) return ;

        // transfer
        let rowData = new Array(models.length);
        for (let i = 0; i < models.length; i++) {
            rowData[i] = models[i].attrs;
        }

        // batchUpdate
        console.log("batchUpdate: ", rowData);
        let result = this._model.batchUpdate(rowData);
        this.processBatchOperationResult(result, refresh);
    }

    // 批量删除数据
    batchDelete(rows, refresh=true){
        if (rows.length < 1) return;

        let deletes = [rows.length];
        for (let i = 0; i < rows.length; i++) {
            deletes[i] = this._model.constructor.fromObject(rows[i]).filterToDelete();
        }
        console.log(deletes);
        let result = this._model.batchDelete(deletes);
        this.processBatchOperationResult(result, refresh);
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 通过条件查询所有数据
    findByCondition(conditionPara){
        return this._model.findByCondition(conditionPara);
    }

    // 通过条件查询一条数据
    findOneByCondition(conditionPara){
        return this._model.findOneByCondition(conditionPara);
    }

    // 通过条件查询一页数据
    findPageByCondition(conditionPara){
        return this._model.findPageByCondition(conditionPara);
    }


// - - - - - - - - - - - - - 数据提交后处理 - - - - - - - - - - - - - - - -


    processBatchOperationResult(result, refresh=true) {
        let time = 3000;
        if (result.success){
            layer.msg(result.successMessage, {time: time}, () => {
                // 刷新页面
                if (refresh) window.location.reload();
            });
            let success = [], failure = [];
            for (let i = 0; i < result.main.length; i++) {
                (result.main[i]) ? success.push(i) : failure.push(i);
            }
            console.log("success: ", success.length, ", failure: ", failure.length);
        }else if(result.needLogin){
            layer.msg(result.message, {time: 1500}, () => {
                this.processNeedLogin();
            });
        }else{
            this.processError(result);
        }
    }

    processNeedLogin(){
        top.layer.open({
            type: 2,
            title: "登录",
            area: ['300px', '400px'],
            content: '/simpleLogin',
            closeBtn: 0,
            move: false,
            cancel: (index) => {return false;}
        });
    }

    processError(result={}){
        layer.alert(result.errorMessage);
    }

    simpleProcessSubmitResult(result, time){
        if (result.success){
            layer.msg(result.successMessage, {time: time});
        }else{
            this.processError(result);
        }
    }

    commonRefresh(refresh){
        // 刷新
        if (refresh) {
            // 如果为父窗口为选项卡，则刷新父窗口；
            // 若父窗口不为选项卡（为主窗口，不为选项卡之子窗口，当前窗口为选项卡）：
            if(window.parent === window.top){
                // 为选项卡，刷新当前页面
                // 关闭当前页面 todo
                window.location.reload();
            }else{
                // 三级页面（选项卡之子页面）：刷新父页面（选项卡页面）
                window.parent.location.reload();
            }
        }
    }

    processSubmitDeleteResult(result, time=1500, refresh=true) {
        if (result.success){
            layer.msg(result.successMessage, {time: time});
            // 刷新当前页面
            this.commonRefresh(refresh);
        }else{
            this.processError(result);
        }
    }

    processSubmitResult(result, time=1500, refresh=true) {
        if (result.success){
            layer.msg(result.successMessage, {time: time}, () => {
                // 获取当前页面（弹窗）的id，后关闭本页面(弹窗)
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                // 刷新
                this.commonRefresh(refresh);
            });
        }else if(result.needLogin){
            layer.msg(result.message, {time: 1500}, () => {
                this.processNeedLogin();
            });
        }else{
            this.processError(result);
        }
    }

    processAddResult(result, time=1500, refreshParent=true) {
        this.processSubmitResult(result, time, refreshParent);
    }

    processUpdateResult(result, time=1500, refreshParent=true) {
        this.processSubmitResult(result, time, refreshParent);
    }

    processDeleteResult(result, time=1500, refreshPage=true) {
        this.processSubmitDeleteResult(result, time, refreshPage);
    }
}


// bsTable列表格式化类
class BsTableFormat{
    static guid() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            let r = Math.random() * 16 | 0,
                v = (c === 'x') ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    }
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    static url(rowData){
        let temp = '<a href="{{row.url}}" title="{{row..description ? row.description : row.title}}">{{row.title}}</a>';
        return TemplateManager.render("BsTableFormat.url", temp, {row: rowData});
    }

    static description(description="", maxLength=32){
        let temp = description;
        if (temp && maxLength > 4 && temp.length > maxLength){
            temp = temp.split(maxLength - 3) + "...";
        }
        return temp;
    }

    static img(rowData){
        let temp = '<img src="{{row.url}}" class="img-fluid" alt="{{row..description ? row.description : row.title}}">{{row.title}}</img>';
        return TemplateManager.render("BsTableFormat.img", temp, {row: rowData});
    }

    static operate(rowData){
        let temp =
            '<button class="btn btn-primary btn-sm" title="edit" onclick="edit(\'{{row.id}}\')">编辑</button>' +
            '<button class="btn btn-danger btn-sm" title="delete" onclick="deleteById(\'{{row.id}}\')">删除</button>';
        return TemplateManager.render("BsTableFormat.operate", temp, {row: rowData});
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    static input(rowData){
        let temp = '<input type="{{row.inputType}}" name="{{row.name}}" placeholder="{{row.placeholder}}" value="{{row.value}}" class="form-control btf-input {{row.class}}">';
        return TemplateManager.render("BsTableFormat.input", temp, {row: rowData});
    }

    static inputSearch2(rowData){
        rowData["guid"] = this.guid();
        let temp = '\
            <div class="input-group">\
                <input id="{{row.guid}}" type="text" name="{{row.name}}" value="{{row.value}}" class="form-control btf-input {{row.class}}">\
                <span class="input-group-addon input-sm" style="width: 30px;" onclick="{{row.onclick}}(\'{{row.guid}}\');">\
                    <i class="fa fa-search"></i>\
                </span>\
            </div>';
        return TemplateManager.render("BsTableFormat.inputSearch2", temp, {row: rowData});
    }

    static inputText(rowData){
        rowData["inputType"] = "text";
        return BsTableFormat.input(rowData);
    }

    static inputCheckBox(rowData){
        let temp = '<input type="checkbox" name="{{row.name}}" {{row.value ? "checked" : ""}} class="form-control btf-input {{row.class}}">';
        return TemplateManager.render("BsTableFormat.inputCheckBox", temp, {row: rowData});
    }

    static inputRange(rowData){
        rowData["inputType"] = "range";
        return BsTableFormat.input(rowData);
    }

    static inputTel(rowData){
        rowData["inputType"] = "tel";
        return BsTableFormat.input(rowData);
    }

    static inputSearch(rowData){
        rowData["inputType"] = "search";
        return BsTableFormat.input(rowData);
    }

    static inputNumber(rowData){
        rowData["inputType"] = "number";
        return BsTableFormat.input(rowData);
    }

    static inputTime(rowData){
        rowData["inputType"] = "time";
        return BsTableFormat.input(rowData);
    }

    static inputDate(rowData){
        rowData["inputType"] = "date";
        return BsTableFormat.input(rowData);
    }

    static inputDateTime(rowData){
        rowData["inputType"] = "datetime";
        return BsTableFormat.input(rowData);
    }

    static inputDateTimeLocal(rowData){
        rowData["inputType"] = "datetime-local";
        return BsTableFormat.input(rowData);
    }

    static inputColor(rowData){
        rowData["inputType"] = "color";
        return BsTableFormat.input(rowData);
    }

    static inputEmail(rowData){
        rowData["inputType"] = "email";
        return BsTableFormat.input(rowData);
    }

    static inputMonth(rowData){
        rowData["inputType"] = "month";
        return BsTableFormat.input(rowData);
    }

    static inputWeek(rowData){
        rowData["inputType"] = "week";
        return BsTableFormat.input(rowData);
    }

    static select(rowData){
        rowData["guid"] = this.guid();
        let temp = '\
            <select id="{{row.guid}}" name="{{row.name}}" class="form-control btf-input {{row.class}}">\
                {{each row.options item index}}\
                <option value="{{item.value}}" selected="">{{@ item.name}}</option>\
                {{/each}}\
            </select>\
            {{if row.guid}}<script>$("#{{row.guid}}").val("{{row.value}}");</script>{{/if}}'
        ;
        // let dict = SysDict.me.findOneByCondition({name: rowData[""]});
        return TemplateManager.render("BsTableFormat.select", temp, {row: rowData});
    }



    static textArea(rowData){
        let temp = '<textarea name="{{row.name}}" class="form-control full-width btf-input {{row.class}}">{{@ row.value}}</textarea>';
        return TemplateManager.render("BsTableFormat.textArea", temp, {row: rowData});
    }
}




class MyImgUpload{
    imgId;
    imgType;
    imgFileId;
    clearBtnId;
    upImgBtnId;
    previewBtnId;
    imgPreviewDiv;
    inputImageLabel;
    // 文件上传时间间隔应大于1秒
    timestamp = (new Date()).valueOf();
    successUpFile = new Set();

    template = '\
            <div class="row" id="#(imgPreviewContainer)">\
                <div class="col-md-12">\
                    <img id="#(imgPreviewDiv)" src="" class="figure-img img-fluid rounded img-preview" alt="">\
                </div>\
            </div>';
    uploadUrl = "/ueditor/upImage";
    upImgTemp = {name: "", file: {}, img: "", width: 0, height: 0};
    static iconType = "image/x-icon";
    static supportImgTypeList = [
        "image/bmp", "image/cis-cod", "image/gif", "image/ief",
        "image/jpeg", "image/pipeg", "image/svg+xml", "image/tiff",
        "image/x-cmu-raster", "image/x-cmx", "image/x-icon",
        "image/x-portable-anymap", "image/x-portable-bitmap",
        "image/x-portable-graymap", "image/x-portable-pixmap",
        "image/x-rgb", "image/x-xbitmap", "image/x-xpixmap",
        "image/x-xwindowdump",
    ];
    static supportImgTypes = new Set(MyImgUpload.supportImgTypeList);

    constructor(imgType, metaData={title:"",imgId:"", defaultValue:"", randId:""}) {
        if(!imgType) imgType = MyImgUpload.supportImgTypeList.join(",");
        this.imgType = imgType;

        // ui各元素id自动生成
        if(!metaData.randId) metaData.randId = guid();
        this.title = metaData.title;
        this.imgId = metaData.imgId;
        this.imgName = metaData.imgName;
        this.value = metaData.defaultValue;
        this.clearBtnId = "clearBtnId_" + metaData.randId;
        this.upImgBtnId = "upImgBtnId_" + metaData.randId;
        this.previewBtnId = "previewBtnId_" + metaData.randId;
        this.imgFileId = "imgFile_" + metaData.randId;
        this.imgPreviewDiv = "imgPreviewD_" + metaData.randId;
        this.inputImageLabel = "input_image_label_" + metaData.randId;
    }

    init(){
        // 设置默认值
        if(this.value) this.selectImg(this.value);

        $("#"+this.upImgBtnId).on("click", ()=> this.upFile());
        $("#"+this.clearBtnId).on("click", ()=> {this.clearImg();return false});
        $("#"+this.previewBtnId).on("click", ()=> this.previewImg());
        $("#"+this.imgFileId).change((event)=> this.changeImg(event.currentTarget.files[0]));
    }

    getImgShow(){
        let temp = this.template;
        // let temp = document.getElementById("preview").innerHTML;
        let src = 'src="' + this.upImgTemp.img + '"';
        let alt = 'alt="' + this.upImgTemp.name + '"';
        return temp.replace('src=""', src).replace('alt=""', alt);
    }

    // todo 用hash防止重复提交
    upFile(){
        // 文件上传时间间隔应大于1秒
        if((new Date()).valueOf() - this.timestamp < 1000){
            alert("上传文件过于频繁！请稍后重试！");
        }
        this.timestamp = (new Date()).valueOf();

        let formData = new FormData();
        formData.append("upFile", this.upImgTemp.file);
        let result = WebDao.postFile(this.uploadUrl, formData);

        if (processUpFileResult(result, "文件上传")){
            $("#" + this.imgId).val(result["url"]);

        }
        return false;
    }

    getImgInfo(file, success=function (imgData){}){
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function(e) {
            // 图片base64化
            let base64Img = e.target.result;
            //加载图片获取图片真实宽度和高度
            let image = new Image();
            image.src = base64Img;
            // 图片先加载完，才可以得到图片宽度和高度
            image.onload = function(){
                let imgInfo = {img: base64Img, name: file.name, height: image.height, width: image.width};
                success(imgInfo);
            }
            image.onerror = () => {success({})}
            image.onabort = () => {success({})}
        };
    }

    // 选择图片事件
    changeImg(file) {
        console.log(file);
        if(file.type.indexOf("image") === 0) {
            console.log(file.type);
            this.getImgInfo(file, (imgData)=> {
                imgData.file = file;
                this.upImgTemp = imgData;
                this.selectImg();
            });
        }
    };

    previewImg () {
        layer.open({
            type: 1,
            title: "预览",
            maxHeight: 400,
            maxWidth: 500,
            maxmin: true,
            resize: true,
            content: this.getImgShow()
        });
        return false;
    };

    upload() {this.upFile(); };

    selectImg(img=""){
        if (img) this.upImgTemp.img = img;
        $("#"+this.clearBtnId).css("display", "inline");
        $("#"+this.inputImageLabel).css("display", "none");
        $("#"+this.previewBtnId).css("display", "inline");
        $("#"+this.upImgBtnId).css("display", "inline");
    }

    // 清除图片
    clearImg() {
        $("#"+this.imgId).val("");

        $("#"+this.clearBtnId).css("display", "none");
        $("#"+this.previewBtnId).css("display", "none");
        $("#"+this.upImgBtnId).css("display", "none");
        $("#"+this.inputImageLabel).css("display", "inline");
        return false;
    };

}



class MetaInfo{
    static me = MetaInfo.byUrl("/api/v1/metaInfo");
    _metaInfoUrl = null;
    _metaInfo = null;

    constructor(metaInfo = null) {
        if (metaInfo){
            this._metaInfo = metaInfo;
            this._createMethod(metaInfo);
        }
    }

    static byUrl(url){
        let temp = new MetaInfo();
        temp.initByUrl(url);
        return temp;
    }

    initByUrl(url){
        let result = WebDao.getJSON(url);
        // console.log("metaInfoResult: ", result);
        if (result.success){
            let metaInfo = result.main;
            if("string" === typeof(result.main)){
                metaInfo = JSON.parse(result.main);
            }
            this._metaInfo = metaInfo;
            this._createMethod(metaInfo);
        }else{
            console.log("metaInfoResult: ", result);
            console.error("error: ", result.message);
        }
    }

    toCamelCase(str){
        let regex = /\.(\w)/g;
        return str.replace(regex, ($0, $1)=> {
            return $1.toUpperCase();
        });
    }

    _createMethod(data, prefix=""){
        if(isArray(data)){
            let dataKey = prefix.substring(1);
            let methodName = this.toCamelCase(dataKey);
            // create method
            // console.log(methodName, ": ", dataKey);
            this.constructor.prototype.__defineGetter__(methodName, ()=> {
                return this.getMetaInfo(dataKey);
            });
            return;
        }

        for (let key in data) {
            if(data.hasOwnProperty(key)){
                this._createMethod(data[key], prefix + "." + key);
            }
        }
    }

    get metaInfo(){
        /*if(null === this._metaInfo && this._metaInfoUrl){
            this.initByUrl(this._metaInfoUrl);
        }*/
        return this._metaInfo;
    }

    getMetaInfo(name=""){
        return this._getMetaInfo(this.metaInfo, name);
    }

    _getMetaInfo(metaInfo, name="this"){
        if ("this" === name){
            return metaInfo;
        }else if (-1 === name.indexOf(".")){
            return metaInfo[name];
        }else {
            // xx.yy.zz
            let names = name.split(".");
            let route = metaInfo;
            for (let temp in names) {
                route = route[names[temp]];
            }
            return route;
        }
    }

}


