import { useNavigate, useParams } from 'react-router-dom';
import { 
    Card,
    Group,
    Stack,
    Tabs,
    Button
} from '@mantine/core';
import { IconScript, IconScriptPlus, IconUser } from "@tabler/icons-react";
import UserInfo from './UserInfo';
import classes from "../styles.module.css";
import PostForm from './PostForm';

function Menu({ user }) {
    const navigate = useNavigate();

    return (
        <Card className={classes.menu}>
            <Stack justify="flex-start" align="flex-start">
                <Group>
                    <UserInfo user={user} />
                </Group>
                <nav style={{width: "100%"}}>
                    <Tabs 
                        variant="pills" 
                        orientation="vertical" 
                        defaultValue="posts/all"
                        onChange={(value) => navigate(`/${value}`)}
                    >
                        <Tabs.List 
                            justify="center" 
                            grow
                            style={{width: "100%"}}
                        >
                            <Tabs.Tab 
                                value="posts/all" 
                                leftSection={<IconScript />}
                            >
                                All
                            </Tabs.Tab>
                            <Tabs.Tab 
                                value="posts/followed" 
                                leftSection={<IconScriptPlus />}
                            >
                                Followed
                            </Tabs.Tab>
                            <Tabs.Tab 
                                value="users" 
                                leftSection={<IconUser />}
                            >
                                Users
                            </Tabs.Tab>
                        </Tabs.List>
                    </Tabs>
                </nav>
                <PostForm />
            </Stack>
        </Card>
    );
}

export default Menu;