webpackJsonp([5],{ASvP:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"reportList"},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"id",label:"id",width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"name",label:"名称",width:"240",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"日期",width:"200",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"right",label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return t.handleClick(e.row)}}},[t._v("查看")]),t._v(" "),a("el-button",{attrs:{type:"text",size:"small"}},[t._v("编辑")]),t._v(" "),a("el-button",{attrs:{type:"text",size:"small"}},[t._v("删除")])]}}])})],1)],1)},staticRenderFns:[]};var l=a("VU/8")({data:function(){return{tableData:[]}},mounted:function(){this.initData()},methods:{initData:function(){var t=this;this.$store.dispatch("report/getHistoryList").then(function(e){t.tableData=e.obj})},handleClick:function(t){this.$router.push("/report/reportDeatils/"+t.createTime)}}},n,!1,function(t){a("yBe7")},null,null);e.default=l.exports},yBe7:function(t,e){}});
//# sourceMappingURL=5.2c66165248dfe0c70e81.js.map