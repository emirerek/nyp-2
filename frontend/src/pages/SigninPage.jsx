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
import { Link } from 'react-router-dom';

function SigninPage() {
    return (
        <Container size={384} my={64}>
            <Title ta="center">
                Sign in
            </Title>
            <Text c="dimmed" size="md" ta="center" mt={5}>
                Create your account
            </Text>
            <Paper withBorder shadow="md" p={30} mt={30} radius="md">
                <TextInput label="Username" placeholder="Your username" required />
                <PasswordInput label="Password" placeholder="Your password" required mt="md" />
                <Button fullWidth mt="xl" mb="md">
                    Sign in
                </Button>
                <Anchor
                    component={Link}
                    to="/login"
                    ta="center"
                >
                    Log in to enter your account
                </Anchor>
            </Paper>
        </Container>
    );
}

export default SigninPage;