import request from '@/utils/request'
import apiTypes from './api-types';
import store from '@/store'

// 通用增删改查
export function findAll(src) {
    console.log("findAll api :" + src)
    return request({
        url: src,
        method: 'GET'
    })
}

export function findByPage(src, { page, limit }) {
    console.log("findByPage api :" + src)
    return request({
        url: src + '/',
        method: 'GET',
        params: {
            page: page,
            limit: limit
        }
    })
}

export function remove(src, params) {
    console.log("remove api :" + src)
    return request({
        url: src + "/",
        method: 'DELETE',
        params: params
    })
}

export function offer(src, data) {
    console.log("offer api :" + src)
    return request({
        url: src + "/",
        method: 'POST',
        data: data
    })
}

export function patch(src, data) {
    console.log("patch api :" + src)
    return request({
        url: src + "/",
        method: 'PUT',
        data: data
    });
}