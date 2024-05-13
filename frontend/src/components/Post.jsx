import { useState } from "react";
import { Link } from "react-router-dom";
import { 
    Card, 
    Text, 
    Group, 
    Stack, 
    Image, 
    Button
} from '@mantine/core';
import UserPreview from "./UserPreview";
import ButtonComment from "./ButtonComment";
import ButtonLike from "./ButtonLike";
import { convertToDate } from "../util/util";
import PostFormEdit from "./PostFormEdit";

function Post({ post }) {
    return (
        <Card>
            <Group justify="flex-start" align="flex-start">
                <UserPreview user={post.user} />
                <Stack>
                    <Text size="md">
                        {post.textContent}
                    </Text>
                </Stack>
            </Group>
            <Group mt={8} justify="space-between" align="center">
                <Text c="dimmed">
                    {convertToDate(post.creationDate)}
                </Text>
                <Group>
                    <ButtonComment path={"/posts/" + post.id}>
                        {post.commentCount}
                    </ButtonComment>
                    <ButtonLike postId={post.id}>
                        {post.likeCount}
                    </ButtonLike>
                    {
                        post.user.id === 1 
                        ?
                        <PostFormEdit postId={post.id}/>
                        :
                        null
                    }
                </Group>
            </Group>
        </Card>
    );
}

export default Post;