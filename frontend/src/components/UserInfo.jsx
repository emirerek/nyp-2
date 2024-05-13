import { Link } from 'react-router-dom';
import { Text, Group, Avatar, Stack, Anchor } from '@mantine/core';
import { getInitialsFromUsername } from '../util/util';

function UserInfo({ user }) {
    return (
        <Group justify="flex-start" align="center">
            <Avatar>
                {getInitialsFromUsername(user.username)}
            </Avatar>
            <Stack gap={0}>
                <Anchor 
                    component={Link} 
                    to={"/users/" + user.id}
                    underline="hover"
                    c="white"
                >
                    {user.username}
                </Anchor>
                <Text size="sm" c="dimmed">
                    {user.followerCount + " followers"}
                </Text>
            </Stack>
        </Group>
    );
}

export default UserInfo;