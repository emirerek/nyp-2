import { Link, useNavigate } from 'react-router-dom';
import {
    TextInput,
    PasswordInput,
    Anchor,
    Paper,
    Title,
    Text,
    Container,
    Button,
} from '@mantine/core';

function LoginPage() {
    const navigate = useNavigate();
    const { login, error } = useAuthContext();

    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        console.log(formData.get("username"))
        const body = JSON.stringify({
            username: formData.get("username"),
            password: formData.get("password")
        });
        console.log(body)
        login(body);
        if (!error) {
            console.log("test")
            navigate("/posts");
        }
    }

    return (
        <Container size={384} my={64}>
            <Title ta="center">
                Login
            </Title>
            <Text c="dimmed" size="md" ta="center" mt={5}>
                Login to your account
            </Text>
            <Paper withBorder shadow="md" p={30} mt={30} radius="md">
                <form onSubmit={handleSubmit}>
                    <TextInput label="Username" name="username" placeholder="Your username" required />
                    <PasswordInput label="Password" name="password" placeholder="Your password" required mt="md" />
                    <Button fullWidth mt="xl" mb="md" type="submit">
                        Log in
                    </Button>
                    <Anchor
                        component={Link}
                        to="/signin"
                        ta="center"
                    >
                        Sign in to create an account
                    </Anchor>
                </form>
            </Paper>
        </Container>
    );
}

export default LoginPage;