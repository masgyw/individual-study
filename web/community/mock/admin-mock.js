import mockdata from './mockdata'

const tokens = {
  admin: {
    token: 'admin-token'
  },
  editor: {
    token: 'editor-token'
  }
}

const users = {
  'admin-token': {
    roles: ['admin'],
    introduction: 'I am a super administrator',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Super Admin',
    userName: 'Super Admin',
    role: {
      roleName: 'admin'
    }
  },
  'editor-token': {
    roles: ['editor'],
    introduction: 'I am an editor',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Normal Editor',
    userName: 'Normal Editor',
    role: {
      roleName: 'normal'
    }
  }
}

export default [
  // user login
  {
    url: '/user/login',
    type: 'post',
    response: config => {
      const { userName } = config.body
      const token = tokens[userName]

      // mock error
      if (!token) {
        return {
          code: 60204,
          message: 'Account and password are incorrect.'
        }
      }

      return {
        code: 20000,
        data: token
      }
    }
  },

  // user page
  {
    url: '/user/page',
    type: 'get',
    response: _ => {
      let records = [];
      records.push(mockdata.user);
      records.push(mockdata.user);
      records.push(mockdata.user);

      return {
        code: 20000,
        data: {
          total: records.length,
          records: records
        }
      }
    }
  },

  // get user info
  {
    url: '/user/\.*',
    type: 'get',
    response: config => {
      const { token } = config.query
      const info = users[token]

      // mock error
      if (!info) {
        return {
          code: 50008,
          message: 'Login failed, unable to get user details.'
        }
      }

      return {
        code: 20000,
        data: info
      }
    }
  },

  // user logout
  {
    url: '/user/logout',
    type: 'post',
    response: _ => {
      return {
        code: 20000,
        data: 'success'
      }
    }
  },

  // role page
  {
    url: '/role/page',
    type: 'get',
    response: _ => {
      let records = [];
      records.push(mockdata.role);
      records.push(mockdata.role);
      records.push(mockdata.role);

      return {
        code: 20000,
        data: {
          total: records.length,
          records: records
        }
      }
    }
  },

  // log page
  {
    url: '/log/page',
    type: 'get',
    response: _ => {
      let records = [];
      records.push(mockdata.log);
      records.push(mockdata.log);
      records.push(mockdata.log);

      return {
        code: 20000,
        data: {
          total: records.length,
          records: records
        }
      }
    }
  }

]
