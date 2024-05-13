import { Routes, Route } from "react-router-dom";
import { ScrollArea, Group, Center } from "@mantine/core";
import Menu from "./components/Menu";
import PostsPage from "./pages/PostsPage";
import FollowedPostsPage from "./pages/FollowedPostsPage";
import PostPage from "./pages/PostPage";
import UsersPage from "./pages/UsersPage";
import UserPage from "./pages/UserPage";
import UserPosts from "./components/UserPosts";
import UserComments from "./components/UserComments";
import UserLikes from "./components/UserLikes";
import classes from "./styles.module.css";
import { useFakeUser } from "./util/hooks";

function App() {
	const [data, error] = useFakeUser();

	if (error) return <span>{error}</span>;
	if (data == null) return;
	return (
		<Group className={classes.wrapper} justify="center" align="start">
			<Menu user={data} />
			<ScrollArea className={classes.content}>
				<Routes>
					<Route path="/posts/all" element={<PostsPage />} />
					<Route path="/posts/followed" element={<FollowedPostsPage />} />
					<Route path="/posts/:postId" element={<PostPage />} />
					<Route path="/users" element={<UsersPage />} />
					<Route path="/users/:userId" element={<UserPage />}>
						<Route path="/users/:userId/posts" element={<UserPosts />} />
						<Route path="/users/:userId/comments" element={<UserComments />} />
						<Route path="/users/:userId/likes" element={<UserLikes />} />
					</Route>
				</Routes>
			</ScrollArea>
		</Group>
	);
}

export default App;
