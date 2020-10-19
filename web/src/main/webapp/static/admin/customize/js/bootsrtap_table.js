
//操作事件放置在最前面
window.operateEvents={
    'click.find':function(e,value,row,index){
        alert('Youclickfindaction,row:'+JSON.stringify(row));
    },
    'click.update':function(e,value,row,index){
        alert('Youclickupdateaction,row:'+JSON.stringify(row));
    },
    'click.remove':function(e,value,row,index){
        $("#student").bootstrapTable('remove',{
            field:'id',
            values:[row.id]
        });
    }
};

//初始化表格，不要缺少
$("#student").bootstrapTable({
    url:"data/student_data.json",//请求后台的URL（*）
    method:'GET',//请求方式（*）
    toolbar:'#toolbar',//工具按钮用哪个容器
    striped:true,//是否显示行间隔色
    cache:false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    pagination:true,//是否显示分页（*）
    showPaginationSwitch:true,//显示切换分页
    showFooter:false,//显示底部，默认不显示
    showFullscreen:false,//显示全屏
    showHeader:true,//显示头部，默认显示
    showExport:true,//显示导出
    showColumns:true,//是否显示所有的列（选择显示的列）
    showRefresh:true,//是否显示刷新按钮
    sortable:true,//是否启用排序
    sortOrder:"asc",//排序方式
    sidePagination:"client",//分页方式：client客户端分页，server服务端分页（*）
    pageNumber:1,//初始化加载第一页，默认第一页,并记录
    pageSize:5,//每页的记录行数（*）
    pageList:[5,10,15,20],//可供选择的每页的行数（*）
    search:true,//是否显示表格搜索
    strictSearch:true,
    minimumCountColumns:2,//最少允许的列数
    clickToSelect:true,//是否启用点击选中行
    uniqueId:"id",//每一行的唯一标识，一般为主键列
    showToggle:true,//是否显示详细视图和列表视图的切换按钮
    cardView:false,//是否显示详细视图
    detailView:false,//是否显示父子表
    columns:[
        {
            field:'state',
            checkbox:true,
            align:'center',
            valign:'middle'
        },
        {
            title:'学号',
            field:'id',
            align:'center',
            valign:'middle',
            sortable:true
        },
        {
            title:'姓名',
            field:'name',
            sortable:true,
            editable:false,
            align:'center'
        },{
            title:'年龄',
            field:'age',
            sortable:true,
            editable:false,
            align:'center'
        },{
            title:'性别',
            field:'gender',
            sortable:true,
            align:'center'
        },{
            title:'操作',
            field:'operate',
            align:'center',
            events:operateEvents,
            formatter:operateFormatter
        }
    ]
});

function operateFormatter(value, row, index){
    let operation = [
        '<a class="btn btn-primary btn-sm find" href="javascript:void(0)" title="Select">Select</a>',
        '<a class="btn btn-success btn-sm update" href="javascript:void(0)" title="Update">Update</a>',
        '<a class="btn btn-danger btn-sm remove" href="javascript:void(0)" title="Remove">Remove</a>'
    ];
    return operation.join("");
}

window.operateEvents={};