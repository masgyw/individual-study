<template>
  <div class="home" id="home" name="home">
    <!-- 轮播图 -->
    <div class="block">
      <el-carousel height="460px">
        <el-carousel-item v-for="item in carousel" :key="item.productPicId">
          <img style="height:460px;" :src="target + item.picUrl" :alt="item.picDesc" />
        </el-carousel-item>
      </el-carousel>
    </div>
    <!-- 轮播图END -->
    <div class="main-box">
      <div class="main">
        <!-- 手机商品展示区域 -->
        <div class="phone">
          <div class="box-hd">
            <div class="title">手机</div>
          </div>
          <div class="box-bd">
            <div class="promo-list">
              <router-link to>
                <img :src="target + '/phone/phone.png'" :alt="target + 'phone/phone.png'" />
              </router-link>
            </div>
            <div class="list">
              <BaseList :list="phoneList" :isMore="true"></BaseList>
            </div>
          </div>
        </div>
        <!-- 手机商品展示区域END -->

        <!-- 家电商品展示区域 -->
        <div class="appliance" id="promo-menu">
          <div class="box-hd">
            <div class="title">家电</div>
            <div class="more" id="more">
              <BaseMenu :val="2" @fromChild="getChildMsg">
                <span slot="1">热门</span>
                <span slot="2">电视影音</span>
              </BaseMenu>
            </div>
          </div>
          <div class="box-bd">
            <div class="promo-list">
              <ul>
                <li>
                  <img :src="target + '/appliance/appliance-promo1.png'" />
                </li>
                <li>
                  <img :src="target + '/appliance/appliance-promo2.png'" />
                </li>
              </ul>
            </div>
            <div class="list">
              <BaseList :list="applianceList" :isMore="true"></BaseList>
            </div>
          </div>
        </div>
        <!-- 家电商品展示区域END -->

        <!-- 配件商品展示区域 -->
        <div class="accessory" id="promo-menu">
          <div class="box-hd">
            <div class="title">配件</div>
            <div class="more" id="more">
              <BaseMenu :val="3" @fromChild="getChildMsg2">
                <span slot="1">热门</span>
                <span slot="2">保护套</span>
                <span slot="3">充电器</span>
              </BaseMenu>
            </div>
          </div>
          <div class="box-bd">
            <div class="promo-list">
              <ul>
                <li>
                  <img :src="target + '/accessory/accessory-promo1.png'" />
                </li>
                <li>
                  <img :src="target + '/accessory/accessory-promo2.png'" />
                </li>
              </ul>
            </div>
            <div class="list">
              <BaseList :list="accessoryList" :isMore="true"></BaseList>
            </div>
          </div>
        </div>
        <!-- 配件商品展示区域END -->
      </div>
    </div>
  </div>
</template>
<script>

  import BaseList from '@/components/BaseList'
  import BaseMenu from '@/components/BaseMenu'
  import { carousel, promo, hot } from '@/api/product.js'

  export default {
    components: {
      BaseList,
      BaseMenu
    },
    data() {
      return {
        target: '',
        carousel: "", // 轮播图数据
        phoneList: "", // 手机商品列表
        miTvList: "", // 小米电视商品列表
        applianceList: "", // 家电商品列表
        applianceHotList: "", //热门家电商品列表
        accessoryList: "", //配件商品列表
        accessoryHotList: "", //热门配件商品列表
        protectingShellList: "", // 保护套商品列表
        chargerList: "", //充电器商品列表
        applianceActive: 1, // 家电当前选中的商品分类
        accessoryActive: 1 // 配件当前选中的商品分类
      };
    },
    watch: {
      // 家电当前选中的商品分类，响应不同的商品数据
      applianceActive: function (val) {
        // 页面初始化的时候把applianceHotList(热门家电商品列表)直接赋值给applianceList(家电商品列表)
        // 所以在切换商品列表时判断applianceHotList是否为空,为空则是第一次切换,把applianceList赋值给applianceHotList
        if (this.applianceHotList == "") {
          this.applianceHotList = this.applianceList;
        }
        if (val == 1) {
          // 1为热门商品
          this.applianceList = this.applianceHotList;
          return;
        }
        if (val == 2) {
          // 2为电视商品
          this.applianceList = this.miTvList;
          return;
        }
      },
      accessoryActive: function (val) {
        // 页面初始化的时候把accessoryHotList(热门配件商品列表)直接赋值给accessoryList(配件商品列表)
        // 所以在切换商品列表时判断accessoryHotList是否为空,为空则是第一次切换,把accessoryList赋值给accessoryHotList
        if (this.accessoryHotList == "") {
          this.accessoryHotList = this.accessoryList;
        }
        if (val == 1) {
          // 1为热门商品
          this.accessoryList = this.accessoryHotList;
          return;
        }
        if (val == 2) {
          // 2为保护套商品
          this.accessoryList = this.protectingShellList;
          return;
        }
        if (val == 3) {
          //3 为充电器商品
          this.accessoryList = this.chargerList;
          return;
        }
      }
    },
    created() {
      this.target = this.$store.getters.productHost;
      console.log(this.target)
      // 获取轮播图数据
      carousel({}).then(resp => {
        this.carousel = resp.data;
      }).catch(err => {
        console.log(err);
      })
      // 获取各类商品数据
      this.getPromo("手机", "phoneList");
      this.getPromo("电视机", "miTvList");
      this.getPromo("保护套", "protectingShellList");
      this.getPromo("充电器", "chargerList");
      // this.getHot(["电视机", "空调", "洗衣机"], "applianceList");
      // this.getHot(["保护套", "保护膜", "充电器", "充电宝"], "accessoryList");
    },
    methods: {
      // 获取家电模块子组件传过来的数据
      getChildMsg(val) {
        this.applianceActive = val;
      },
      // 获取配件模块子组件传过来的数据
      getChildMsg2(val) {
        this.accessoryActive = val;
      },
      // 获取各类商品数据方法封装
      getPromo(categoryName, val) {
        promo({ "categoryNameList": [categoryName] })
          .then(resp => {
            this[val] = resp.data;
          })
          .catch(err => {

          });
      },
      getHot(categoryName, val) {
        hot({ categoryName })
          .then(resp => {
            this[val] = resp.data;
          }).catch(err => {

          });
      }
    }
  };
</script>
<style scoped>
  @import "../../assets/css/index.css";
</style>