// 异常组件
import NotFound from '@/components/error/NotFound'
// 自定义组件
import UserList from '@/components/users/UserList'
import Login from '@/components/users/Login'
import Register from '@/components/users/Register'
import MyAll from '@/components/demo/MyAll'
// 聊天室
import ChatRoom from '@/components/chat/ChatRoom'
// BootStrap3 学习
import BtsIndex from '@/components/bootstrap/BtsIndex';

export default [
    {
        path: '/demo',
        name: 'demo project',
        component: MyAll
    },
    {
        path: "/list/:userData",
        name: "user list",
        component: UserList
    },
    {
        path: "/login",
        name: "user login",
        component: Login
    },
    {
        path: "/register",
        name: "user register",
        component: Register
    },
    {
        path: "/chat-room",
        name: "chat room",
        component: ChatRoom
    },
    {
        path: "/chat/:userInfo",
        name: "new chat room",
        component: ChatRoom
    },
    {
        path: "/bts",
        name: "bootstrap index",
        component: BtsIndex
    },
    {
        path: "*",
        name: "page not found",
        component: NotFound
    }
]