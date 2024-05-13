import { useNavigate, useLocation, useParams } from 'react-router-dom';
import {
    Card,
    Group,
    Stack,
    Text,
    Avatar,
    Tabs
} from "@mantine/core";
import { IconInbox, IconMessageCircle, IconHeart } from "@tabler/icons-react";
import { getInitialsFromUsername } from "../util/util";
import ButtonFollow from "./ButtonFollow";
import { useEffect } from 'react';

function User({ user }) {
    const navigate = useNavigate();
    const location = useLocation();
    const { userId } = useParams();

    useEffect(() => {
        if (location.pathname === "/users/" + userId) {
            navigate("/users/" + userId + "/posts");
        }
    }, []);

    return (
        <Card>
            <Stack>
                <Group style={{ width: "100%" }} justify="space-between" align="flex-start">
                    <Group justify="space-between" align="flex-start">
                        <Avatar
                            src={user.imageUrl ? imageUrl : null}
                            size="xl"
                        >
                            {
                                user.imageUrl
                                ?
                                null
                                :
                                getInitialsFromUsername(user.username)
                            }
                        </Avatar>
                        <Stack gap={2}>
                            <Text size="xl">
                                {user.username}
                            </Text>
                            <Text>
                                {user.followerCount} followers - {user.followCount} following
                            </Text>
                        </Stack>
                    </Group>
                    <ButtonFollow followedUserId={user.id}/>
                </Group>
                <Tabs
                    variant="pills"
                    defaultValue="posts"
                    onChange={(value) => navigate(`${value}`)}
                >
                    <Tabs.List justify="center" grow>
                        <Tabs.Tab value="posts" leftSection={<IconInbox />}>
                            Posts
                        </Tabs.Tab>
                        <Tabs.Tab value="comments" leftSection={<IconMessageCircle />}>
                            Comments
                        </Tabs.Tab>
                        <Tabs.Tab value="likes" leftSection={<IconHeart />}>
                            Likes
                        </Tabs.Tab>
                    </Tabs.List>
                </Tabs>
            </Stack>
        </Card>
    );
}

export default User;