<template>
  <div class="app-container">
    <table-view :tableDatas="datas" :columns="columns" :pageInfo="pageInfo" 
      @pageChange="query" @deleteRow="deleteRow" @addData="add" >
    </table-view>
  </div>
</template>

<script>
  import apiTypes from '@/api/api-types'
  import { columns } from './meta.js'
  import TableView from '@/components/TableView'

  export default {
    name: "UserMng",
    components: {
      TableView
    },
    data() {
      return {
        columns: columns,
        datas: null,
        pageInfo: {}
      }
    },
    methods: {
      query({ page, limit }) {
        this.BASE_APIS.findByPage(apiTypes.ROLE, { page, limit })
          .then(resp => {
            this.datas = resp.data.records;
            this.pageInfo = resp.data.pageInfo;
          });
      },
      add(params) {
        this.BASE_APIS.offer(apiTypes.ROLE, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      },
      deleteRow(params) {
        this.BASE_APIS.remove(apiTypes.ROLE, {roleId: params.roleId})
          .then(resp => {
            this.query(this.pageInfo);
          })
      }
    },
    created() {
      this.query({ page: 1, limit: 10 });
    }
  }
</script>
<style lang="scss" scoped>
</style>