<template>
  <div class="container">
    <div>
      <el-row>
        <el-col :span="21">
          <el-input type="textarea" v-model="commentDesc" placeholder="写下你的评论..."></el-input>
        </el-col>
        <el-col :span="3">
          <el-button type="success" class="fr" @click="addComment()">发表</el-button>
        </el-col>
      </el-row>
    </div>
    <el-divider></el-divider>
    <div>
      <el-row>
        <el-col :span="6">
          评论 （{{comments.length}}）
        </el-col>
        <el-col :span="6" class="fr">
          <el-button-group>
            <el-button type="primary" plain>最新</el-button>
            <el-button type="primary" plain>最热</el-button>
          </el-button-group>
        </el-col>
      </el-row>
    </div>

    <div class="comment" v-for="(item,idx) in comments">
      <div class="info">
        <img class="avatar" :src="item.fromAvatar" width="36" height="36" />
        <div class="right">
          <div class="name">{{idx+1}}楼 {{item.createdBy}}</div>
          <div class="date">{{item.createdTime}}</div>
        </div>
      </div>
      <div class="content">{{item.content}}</div>
      <div class="control">
        <span class="like" :class="{active: item.isLike}" @click="likeClick(item)">
          <i class="el-icon-thumb"></i>
          <span class="like-num">{{item.likeNum > 0 ? item.likeNum + '人赞' : '赞'}}</span>
        </span>
        <span class="comment-reply" @click="showCommentInput(item)">
          <i class="el-icon-chat-dot-square"></i>
          <span>回复</span>
        </span>
      </div>
      <div class="reply">
        <div class="item" v-for="reply in item.replys" v-if="reply.id">
          <div class="reply-content">
            <span class="from-name">{{reply.createdBy}}</span><span>: </span>
            <span class="to-name">@{{reply.toUserName}}</span>
            <span>{{reply.content}}</span>
          </div>
          <div class="reply-bottom">
            <span>{{reply.createdTime}}</span>
            <span class="reply-text" @click="showCommentInput(item, reply)">
              <i class="iconfont icon-comment"></i>
              <span>回复</span>
            </span>
          </div>
        </div>
        <div class="write-reply" v-if="item.replys.length > 0" @click="showCommentInput(item)">
          <i class="el-icon-edit"></i>
          <span class="add-comment">添加新评论</span>
        </div>
        <transition name="fade">
          <div class="input-wrapper" v-if="showItemId === item.id">
            <el-input class="gray-bg-input" v-model="inputComment" type="textarea" :rows="3" autofocus
              placeholder="写下你的评论">
            </el-input>
            <div class="btn-control">
              <span class="cancel" @click="cancel">取消</span>
              <el-button class="btn" type="success" round @click="commitComment(item)">确定</el-button>
            </div>
          </div>
        </transition>
      </div>
    </div>
  </div>
</template>
<script>

  import { getComments } from '@/api/comment'
  import apiTypes from '@/api/api-types'

  export default {
    name: "CommentPlane",
    props: ['postId'],
    components: {},
    data() {
      return {
        inputComment: '',
        showItemId: '',
        comments: [],
        commentDesc: ''
      }
    },
    computed: {},
    methods: {
      /**
       * 点赞
       */
      likeClick(item) {
        if (item.isLike === null) {
          Vue.$set(item, "isLike", true);
          item.likeNum++
        } else {
          if (item.isLike) {
            item.likeNum--
          } else {
            item.likeNum++
          }
          item.isLike = !item.isLike;
        }
      },

      /**
       * 点击取消按钮
       */
      cancel() {
        this.showItemId = ''
      },

      /**
       * 提交评论
       */
      commitComment(item) {
        let reply = {
          commentId: item.id,
          content: this.inputComment,
          toUserId: item.createdById,
          toUserName: item.createdBy,
          createdBy: this.$store.getters.name,
          createdById: '-2'
        }
        this.BASE_APIS.offer(apiTypes.REPLY, reply)
          .then(resp => {
            this.refresh();
            this.inputComment = '';
            this.cancel()
          })
      },

      /**
       * 点击评论按钮显示输入框
       * item: 当前大评论
       * reply: 当前回复的评论
       */
      showCommentInput(item, reply) {
        // if (reply) {
        //   this.inputComment = "@" + reply.createdBy + " "
        // } else {
        //   this.inputComment = ''
        // }
        this.showItemId = item.id
      },
      refresh() {
        this.getDatas();
      },
      getDatas() {
        getComments(this.postId).then(resp => {
          this.comments = resp.data;
        })
      },
      addComment() {
        let comment = {
          likeNum: 0,
          postId: this.postId,
          content: this.commentDesc,
          createdBy: this.$store.getters.name,
          createdById: '-1'
        }
        this.BASE_APIS.offer(apiTypes.COMMENT, comment)
          .then(resp => {
            this.refresh();
            this.commentDesc = '';
          })
      }
    },
    created() {
      this.getDatas();
    }
  }
</script>
<style lang="scss" scoped>
  @import "~@/styles/variables.scss";

  .container {
    padding: 0 10px;
    box-sizing: border-box;

    .comment {
      display: flex;
      flex-direction: column;
      padding: 10px;
      border-bottom: 1px solid $border-fourth;

      .info {
        display: flex;
        align-items: center;

        .avatar {
          border-radius: 50%;
        }

        .right {
          display: flex;
          flex-direction: column;
          margin-left: 10px;

          .name {
            font-size: 16px;
            color: $text-main;
            margin-bottom: 5px;
            font-weight: 500;
          }

          .date {
            font-size: 12px;
            color: $text-minor;
          }
        }
      }

      .content {
        font-size: 16px;
        color: $text-main;
        line-height: 20px;
        padding: 10px 0;
      }

      .control {
        display: flex;
        align-items: center;
        font-size: 14px;
        color: $text-minor;

        .like {
          display: flex;
          align-items: center;
          margin-right: 20px;
          cursor: pointer;

          &.active,
          &:hover {
            color: $color-main;
          }

          .iconfont {
            font-size: 14px;
            margin-right: 5px;
          }
        }

        .comment-reply {
          display: flex;
          align-items: center;
          cursor: pointer;

          &:hover {
            color: $text-333;
          }

          .iconfont {
            font-size: 16px;
            margin-right: 5px;
          }
        }

      }

      .reply {
        margin: 10px 0;
        border-left: 2px solid $border-first;

        .item {
          margin: 0 10px;
          padding: 10px 0;
          border-bottom: 1px dashed $border-third;

          .reply-content {
            display: flex;
            align-items: center;
            font-size: 14px;
            color: $text-main;

            .from-name {
              color: $color-main;
            }

            .to-name {
              color: $color-main;
              margin-left: 5px;
              margin-right: 5px;
            }
          }

          .reply-bottom {
            display: flex;
            align-items: center;
            margin-top: 6px;
            font-size: 12px;
            color: $text-minor;

            .reply-text {
              display: flex;
              align-items: center;
              margin-left: 10px;
              cursor: pointer;

              &:hover {
                color: $text-333;
              }

              .icon-comment {
                margin-right: 5px;
              }
            }
          }
        }

        .write-reply {
          display: flex;
          align-items: center;
          font-size: 14px;
          color: $text-minor;
          padding: 10px;
          cursor: pointer;

          &:hover {
            color: $text-main;
          }

          .el-icon-edit {
            margin-right: 5px;
          }
        }

        .fade-enter-active,
        fade-leave-active {
          transition: opacity 0.5s;
        }

        .fade-enter,
        .fade-leave-to {
          opacity: 0;
        }

        .input-wrapper {
          padding: 10px;

          .gray-bg-input,
          .el-input__inner {
            /*background-color: #67C23A;*/
          }

          .btn-control {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding-top: 10px;

            .cancel {
              font-size: 16px;
              color: $text-normal;
              margin-right: 20px;
              cursor: pointer;

              &:hover {
                color: $text-333;
              }
            }

            .confirm {
              font-size: 16px;
            }
          }
        }
      }
    }
  }
</style>