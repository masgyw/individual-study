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
    isAdd: true,
    isEdit: false
  },
  {
    prop: "userNameCn",
    label: "中文名",
    width: "100",
    isShow: true,
    isAdd: true,
    isEdit: true
  },
  {
    prop: "password",
    label: "密码",
    width: "100",
    isShow: false,
    isAdd: true,
    isEdit: true
  },
  {
    prop: "status",
    label: "是否启用",
    type: "switch",
    width: "80",
    isShow: true,
    isAdd: true,
    isEdit: true
  },
  {
    prop: "roleId",
    label: "角色",
    type: "select",
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
  },
  {
    prop: "avatar",
    label: "用户头像",
    type: "file",
    isShow: false,
    isAdd: true,
    isEdit: true
  }
]