export const columns = [
  {
    prop: "uid",
    label: "用户编号",
    width: "100",
    isShow: true,
    isAdd: false
  },
  {
    prop: "userName",
    label: "用户名",
    width: "100",
    isShow: true,
    isAdd: true
  },
  {
    prop: "userNameCn",
    label: "中文名",
    width: "100",
    isShow: true,
    isAdd: true
  },
  {
    prop: "status",
    label: "是否启用",
    type: "switch",
    width: "80",
    isShow: true,
    isAdd: true
  },
  {
    prop: "createdTime",
    label: "创建时间",
    width: "160",
    isShow: true,
    isAdd: false
  }
]