<template>
  <div class="app-container">
    <table-view :tableDatas="datas" :columns="columns" :pageInfo="pageInfo"
      @pageChange="query"
      >
    </table-view>
  </div>
</template>

<script>
  import apiTypes from '@/api/api-types'
  import { columns } from './meta.js'
  import TableView from '@/components/TableView'

  export default {
    name: "LogMng",
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
      query({page, limit}) {
        this.BASE_APIS.findByPage(apiTypes.LOG, { page, limit })
          .then(resp => {
            this.datas = resp.data.records;
            this.pageInfo = resp.data.pageInfo;
          });
      }
    },
    created() {
      this.query({ page: 1, limit: 10 });
    }
  }
</script>
<style lang="scss" scoped>
</style>