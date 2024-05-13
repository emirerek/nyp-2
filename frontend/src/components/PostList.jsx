import Post from "./Post";

function PostList({ posts }) {
    return posts.map((post) => <Post post={post} key={post.id}/>);
}

export default PostList;