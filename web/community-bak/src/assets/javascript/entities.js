const entities = {
  post: [
    {
      prop: "uid",
      label: "帖子编号",
      isShow: false, // form 表单是否显示,默认true
      formType: "input", // 表单类型，默认 input
      width: "100" // 定义table column width
    },
    {
      prop: "postTitle",
      label: "帖子标题",
      width: "100"
    },
    {
      prop: "postContent",
      label: "帖子内容",
      formType: "textarea",
      width: "100"
    },
    {
      prop: "createdBy",
      label: "创建人",
      isShow: false,
      width: "80"
    },
    {
      prop: "createdById",
      label: "创建人ID",
      isShow: false,
      width: "80"
    },
    {
      prop: "createdTime",
      label: "创建时间",
      isShow: false,
      width: "160"
    },
    {
      prop: "modifiedTime",
      label: "更新时间",
      isShow: false,
      width: "160"
    }
]
}

export default entities;