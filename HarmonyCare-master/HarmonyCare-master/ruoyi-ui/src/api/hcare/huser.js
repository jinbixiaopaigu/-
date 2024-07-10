import request from '@/utils/request'

// 查询Hcare用户列表
export function listHuser(query) {
  return request({
    url: '/hcare/huser/list',
    method: 'get',
    params: query
  })
}

// 查询Hcare用户详细
export function getHuser(hcUserid) {
  return request({
    url: '/hcare/huser/' + hcUserid,
    method: 'get'
  })
}

// 新增Hcare用户
export function addHuser(data) {
  return request({
    url: '/hcare/huser',
    method: 'post',
    data: data
  })
}

// 修改Hcare用户
export function updateHuser(data) {
  return request({
    url: '/hcare/huser',
    method: 'put',
    data: data
  })
}

// 删除Hcare用户
export function delHuser(hcUserid) {
  return request({
    url: '/hcare/huser/' + hcUserid,
    method: 'delete'
  })
}
