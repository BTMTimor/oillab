
function commonDataFormat(){
    return [
        {name: "-", value: ""},
        {name: "yyyy", value: 1},
        {name: "yyyy-MM", value: 2},
        {name: "yyyy-MM-dd", value: 3},
        {name: "yyyy-MM-dd HH", value: 4},
        {name: "yyyy-MM-dd HH:mm", value: 5},
        {name: "yyyy-MM-dd HH:mm:ss", value: 6}
    ];
}

function selectDictType(id){
    layer.open({
        type: 2,
        title: "选中字典类型",
        area: ['700px', '550px'],
        maxmin: true,
        resize: true,
        btn: ['保存','关闭'],
        content: ['/gen/dictType', 'no'],
        yes: (index, layero)=> {
            $("#" + id).val($(layero).find("iframe")[0].contentWindow.dictType);
            layer.close(index);
        }
    });
}

function primaryKeyRule(){

}

function uploadConfig(){

}

// - -

function javaTypeFmt(value, row, index) {
    let data = {name: "javaType", value: row["javaType"], class: "table-filed"};
    // data["options"] = SysDict.me.findByCondition({name: "javaType"});
    data["options"] = [
        {name: "String", value: "java.lang.String"},
        {name: "Boolean", value: "java.lang.Boolean"},
        {name: "Short", value: "java.lang.Short"},
        {name: "Integer", value: "java.lang.Integer"},
        {name: "Long", value: "java.lang.Long"},
        {name: "Float", value: "java.lang.Float"},
        {name: "Double", value: "java.lang.Double"},
        {name: "BigInteger", value: "java.math.BigInteger"},
        {name: "BigDecimal", value: "java.math.BigDecimal"},
        {name: "Date", value: "java.lang.Date"},
        {name: "Timestamp", value: "java.sql.Timestamp"}
    ];
    return BsTableFormat.select(data);
}

function javaFieldFmt(value, row, index) {
    let data = {name: "javaField", value: row["javaField"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function commentFmt(value, row, index) {
    let data = {name: "comment", value: row["comment"], class: "table-filed"};
    return BsTableFormat.textArea(data);
}

function insertTypeFmt(value, row, index) {
    let data = {name: "insertType", value: row["insertType"], class: "table-filed"};
    data["options"] = [{value: 1, name: "正常"}, {value: 2, name: "只读"}, {value: 5, name: "系统填充"}];
    return BsTableFormat.select(data);
}

function ajaxInsertTypeFmt(value, row, index) {
    let data = {name: "ajaxInsertType", value: row["ajaxInsertType"], class: "table-filed"};
    data["options"] = [{value: 1, name: "正常"}, {value: 2, name: "只读"}, {value: 3, name: "隐藏"}, {value: 4, name: "禁用"}];
    return BsTableFormat.select(data);
}

function ajaxUpdateTypeFmt(value, row, index) {
    let data = {name: "ajaxUpdateType", value: row["ajaxUpdateType"], class: "table-filed"};
    data["options"] = [{value: 1, name: "正常"}, {value: 2, name: "只读"}, {value: 3, name: "隐藏"}, {value: 4, name: "禁用"}];
    return BsTableFormat.select(data);
}

function updateTypeFmt(value, row, index) {
    let data = {name: "updateType", value: row["updateType"], class: "table-filed"};
    data["options"] = [{value: 1, name: "正常"}, {value: 2, name: "只读"}, {value: 5, name: "系统填充"}];
    return BsTableFormat.select(data);
}

function needForGetFmt(value, row, index) {
    let data = {name: "needForGet", value: row["needForGet"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function needForDeleteFmt(value, row, index) {
    let data = {name: "needForDelete", value: row["needForDelete"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function findTypeFmt(value, row, index) {
    let data = {name: "findType", value: row["findType"], class: "table-filed"};
    data["options"] = [{value: "", name: ' - '},
        {value: "EQ", name: '='}, {value: "NE", name: '!='},
        {value: "GT", name: '&gt;'}, {value: "GTE", name: '&gt;='},
        {value: "LT", name: '&lt;'}, {value: "LTE", name: '&lt;='},
        {value: "LIKE", name: 'Like'}, { value: "BETWEEN", name: 'Between'}];
    return BsTableFormat.select(data);
}


function findOneTypeFmt(value, row, index) {
    let data = {name: "findOneType", value: row["findOneType"], class: "table-filed"};
    data["options"] = [{value: "", name: ' - '},
        {value: "EQ", name: '='}, {value: "NE", name: '!='},
        {value: "GT", name: '&gt;'}, {value: "GTE", name: '&gt;='},
        {value: "LT", name: '&lt;'}, {value: "LTE", name: '&lt;='},
        {value: "LIKE", name: 'Like'}, { value: "BETWEEN", name: 'Between'}];
    return BsTableFormat.select(data);
}

function filterForReturnFmt(value, row, index) {
    let data = {name: "filterForReturn", value: row["filterForReturn"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function isRequiredFmt(value, row, index) {
    let data = {name: "isRequired", value: row["isRequired"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function queryTypeFmt(value, row, index) {
    let data = {name: "queryType", value: row["queryType"], class: "table-filed"};
    data["options"] = [{value: "", name: ' - '},
        {value: "EQ", name: '='}, {value: "NE", name: '!='},
        {value: "GT", name: '&gt;'}, {value: "GTE", name: '&gt;='},
        {value: "LT", name: '&lt;'}, {value: "LTE", name: '&lt;='},
        {value: "LIKE", name: 'Like'}, { value: "BETWEEN", name: 'Between'}];
    return BsTableFormat.select(data);
}

function htmlTypeFmt(value, row, index) {
    let data = {name: "htmlType", value: row["htmlType"], class: "table-filed"};
    data["options"] = [
        {name: "隐藏", value: "hidden"},
        {name: "文本框", value: "text"},
        {name: "下拉框", value: "select"},
        {name: "单选框", value: "radio"},
        {name: "复选框", value: "checkbox"},
        {name: "多选框", value: "checkboxes"},
        {name: "数字", value: "number"},
        {name: "范围内数字", value: "range"},
        {name: "邮箱", value: "email"},
        {name: "链接", value: "url"},
        {name: "搜索域", value: "search"},
        {name: "图片", value: "image"},
        {name: "文件", value: "file"},
        {name: "颜色", value: "color"},
        {name: "密码框", value: "password"},
        {name: "文本域", value: "textarea"},
        {name: "富文本", value: "fullText"},
        {name: "ueditor", value: "ueditor"},
        {name: "summerNote", value: "summerNote"},
        {name: "日期和时间", value: "datetime"},
        {name: "本地时日", value: "datetime-local"},
        {name: "日期", value: "date"},
        {name: "月份", value: "month"},
        {name: "周", value: "week"},
        {name: "时间", value: "time"}
    ];
    return BsTableFormat.select(data);
}

function defaultValueFmt(value, row, index) {
    let data = {name: "defaultValue", value: row["defaultValue"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function dictTypeFmt(value, row, index) {
    let data = {name: "dictType", value: row["dictType"], onclick: "selectDictType", class: "table-filed"};
    return BsTableFormat.inputSearch2(data);
}

function uploadConfigFmt(value, row, index) {
    let data = {name: "uploadConfig", value: row["uploadConfig"], onclick: "uploadConfig", class: "table-filed"};
    return BsTableFormat.inputSearch2(data);
}

function primaryKeyRuleFmt(value, row, index) {
    let data = {name: "primaryKeyRule", value: row["primaryKeyRule"], onclick: "primaryKeyRule", class: "table-filed"};
    return BsTableFormat.inputSearch2(data);
}

function placeholderFmt(value, row, index) {
    let data = {name: "placeholder", value: row["placeholder"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function listWidthFmt(value, row, index) {
    let data = {name: "listWidth", value: row["listWidth"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function listFormatFmt(value, row, index) {
    let data = {name: "listFormat", value: row["listFormat"], readonly: row["readonly"], class: "table-filed"};
    data["options"] = [{name: " - ", value: ""}, {name: "文本", value: 0},
        {name: "连接", value: 1}, {name: "图片", value: 2}, {name: "描述", value: 3}];
    return BsTableFormat.select(data);
}

function listAlignFmt(value, row, index) {
    let data = {name: "listAlign", value: row["listAlign"], class: "table-filed"};
    data["options"] = [{name: " - ", value: ""}, {name: "左对齐", value: "left"}, {name: "右对齐", value: "right"}, {name: "居中", value: "center"}];
    return BsTableFormat.select(data);
}

function listSortFmt(value, row, index) {
    let data = {name: "listSort", value: row["listSort"], class: "table-filed"};
    data["options"] = [{name: " - ", value: 0}, {name: "可排序", value: 1}, {name: "默认降序", value: 2}, {name: "默认升序", value: 3}];
    return BsTableFormat.select(data);
}

function isListHideFmt(value, row, index) {
    let data = {name: "isListHide", value: row["isListHide"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function isListDefaultHideFmt(value, row, index) {
    let data = {name: "isListDefaultHide", value: row["isListDefaultHide"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function isInlineEditFmt(value, row, index) {
    let data = {name: "isInlineEdit", value: row["isInlineEdit"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputCheckBox(data);
}

function dateFormatFmt(value, row, index) {
    let data = {name: "dateFormat", value: row["dateFormat"], class: "table-filed"};
    data["options"] = commonDataFormat();
    return BsTableFormat.select(data);
}

function validateTypeFmt(value, row, index) {
    let data = {name: "validateType", value: row["validateType"], class: "table-filed"};
    data["options"] = [{name: "-", value: ""}, {name: "手机", value: "1"}, {name: "邮箱", value: "2"}, {name: "电话", value: "3"}, {name: "url", value: "4"}, {name: "ip地址", value: "5"}];
    return BsTableFormat.select(data);
}

function validateRegexFmt(value, row, index) {
    let data = {name: "validateRegex", value: row["validateRegex"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function rangeLengthFmt(value, row, index) {
    let data = {name: "rangeLength", value: row["rangeLength"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function rangeValueFmt(value, row, index) {
    let data = {name: "rangeValue", value: row["rangeValue"], readonly: row["readonly"], class: "table-filed"};
    return BsTableFormat.inputText(data);
}

function dateQueryFormatFmt(value, row, index) {
    let data = {name: "dateQueryFormat", value: row["dateQueryFormat"], class: "table-filed"};
    data["options"] = commonDataFormat();
    return BsTableFormat.select(data);
}

